package asherflo.com.drone.service;

import asherflo.com.drone.dto.request.AddMedicationRequest;
import asherflo.com.drone.dto.response.*;
import asherflo.com.drone.dto.request.DroneRegistrationRequest;
import asherflo.com.drone.dto.request.LoadDroneRequest;
import asherflo.com.drone.exceptions.DroneException;
import asherflo.com.drone.model.Drone;
import asherflo.com.drone.model.Medication;
import asherflo.com.drone.model.enums.DroneState;
import asherflo.com.drone.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService{

    private final DroneRepository droneRepository;
    private final MedicationService medicationService;
    @Override
    public DroneResponse registerDrone(DroneRegistrationRequest droneRegistrationRequest) throws DroneException {
        Optional<Drone> exists = droneRepository.findBySerialNumber(droneRegistrationRequest.getSerialNumber());
        if(exists.isPresent()){
            throw new DroneException("Drone specified already exists");
        }

        Drone drone = Drone.builder()
                .droneState(DroneState.IDLE)
                .batteryCapacity(droneRegistrationRequest.getBatteryCapacity())
                .serialNumber(droneRegistrationRequest.getSerialNumber())
                .droneModel(droneRegistrationRequest.getDroneModel())
                .build();
        Drone savedDrone = droneRepository.save(drone);
        return buildDroneResponse(savedDrone);
    }

    @Override
    public LoadDroneResponse loadDrone(LoadDroneRequest loadRequest) throws DroneException {
        Optional <Drone> savedDrone = droneRepository.findBySerialNumber(loadRequest.getSerialNumber());
        if (savedDrone.isEmpty()) {
            throw new DroneException("Drone specified does not exist");
        }
        Drone drone = savedDrone.get();
        if (drone.cumulateLoadedWeight() >= drone.getWEIGHT_LIMIT() || (drone.cumulateLoadedWeight() + loadRequest.getWeight()) > drone.getWEIGHT_LIMIT()) {
            throw new DroneException("The Drone cannot load more than the weight limit");
        }
        AddMedicationRequest request = buildMedicalRequest(loadRequest);
        Medication medication = medicationService.addMedication(request);

        drone.getMedications().add(medication);
        droneRepository.save(drone);

        LoadDroneResponse loadDroneResponse = new LoadDroneResponse();
        loadDroneResponse.setMessage("Drone loaded successfully");
        loadDroneResponse.setMedication(medication);
        return loadDroneResponse;
    }
    private void changeDroneStatus(Drone drone) {
        if(drone.cumulateLoadedWeight() < drone.getWEIGHT_LIMIT()){
            drone.setDroneState(DroneState.LOADING);
        }
        if(drone.cumulateLoadedWeight() == drone.getWEIGHT_LIMIT()){
            drone.setDroneState(DroneState.LOADED);
        }
    }


    @Override
    public List<MedicationResponse> checkLoadedMedications(String serialNumber) throws DroneException {
        Optional <Drone> savedDrone = droneRepository.findBySerialNumber(serialNumber);
        if (savedDrone.isEmpty()) {
            throw new DroneException("Drone specified does not exist");
        }
        Drone drone = savedDrone.get();
        return drone.getMedications().stream().map(this:: buildMedicalResponse).toList();
    }

    @Override
    public List<DroneResponse> viewAvailableDrone() {
        var drones =  droneRepository.findByAvailableDroneByState();
        return drones.stream().map(this::buildDroneResponse).toList();
    }
    @Override
    public BatteryResponse batteryCheck(String serialNumber) throws DroneException {
        Optional <Drone> found = droneRepository.findBySerialNumber(serialNumber);
        if(found.isEmpty()){
            throw new DroneException("Not found");
        }
        Drone drone = found.get();
        return BatteryResponse.builder()
                .batteryLevel(drone.getBatteryCapacity())
                .serialNumber(drone.getSerialNumber())
                .droneModel(drone.getDroneModel().toString())
                .build();
    }

    private BatteryResponse createAuditResponse(Drone drone){
        return BatteryResponse.builder()
//                .serialNumber(drone.getId())
                .droneModel(drone.getDroneModel().toString())
                .serialNumber(drone.getSerialNumber())
                .batteryLevel(drone.getBatteryCapacity())
                .build();
    }

    private AddMedicationRequest buildMedicalRequest(LoadDroneRequest request){
        return AddMedicationRequest.builder()
                .name(request.getName())
                .code(request.getCode())
                .imageUrl(request.getImage())
                .weight(request.getWeight())
                .build();
    }

    private MedicationResponse buildMedicalResponse(Medication medication){
        return MedicationResponse.builder()
                .name(medication.getName())
                .code(medication.getCode())
                .image(medication.getImage())
                .weight(medication.getWeight())
                .build();
    }
    private DroneResponse buildDroneResponse(Drone drone){
        return DroneResponse.builder()
                .batteryCapacity(drone.getBatteryCapacity())
                .droneModel(drone.getDroneModel().toString())
                .droneState(drone.getDroneState().toString())
                .loadedWeight(drone.getLoadedWeight())
                .medications(drone.getMedications())
                .weightLimit(drone.getWEIGHT_LIMIT())
                .serialNumber(drone.getSerialNumber())
                .build();
    }





}
