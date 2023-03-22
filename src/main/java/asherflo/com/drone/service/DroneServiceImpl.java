package asherflo.com.drone.service;

import asherflo.com.drone.dto.response.AvailableDroneResponse;
import asherflo.com.drone.dto.response.LoadDroneResponse;
import asherflo.com.drone.dto.request.DroneRegistrationRequest;
import asherflo.com.drone.dto.response.DroneResponse;
import asherflo.com.drone.dto.request.LoadDroneRequest;
import asherflo.com.drone.model.Drone;
import asherflo.com.drone.model.Medication;
import asherflo.com.drone.model.enums.DroneModel;
import asherflo.com.drone.model.enums.DroneState;
import asherflo.com.drone.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService{

    private final DroneRepository droneRepository;
    @Override
    public DroneResponse registerDrone(DroneRegistrationRequest droneRegistrationRequest) {
        Optional<Drone> exists = droneRepository.findBySerialNumber(droneRegistrationRequest.getSerialNumber());
        if(exists.isPresent()){
            throw new RuntimeException("Drone specified already exists");
        }

        Drone drone = Drone.builder()
                .droneState(DroneState.LOADING)
                .batteryCapacity(droneRegistrationRequest.getBatteryCapacity())
                .serialNumber(droneRegistrationRequest.getSerialNumber())
                .weightLimit(droneRegistrationRequest.getWeightLimit())
                .droneModel(DroneModel.HEAVYWEIGHT)
                .build();
        Drone savedDrone = droneRepository.save(drone);
        DroneResponse response = new DroneResponse();
        response.setMessage("Drone successfully registered");
        response.setDrone(savedDrone);
        return response;
    }

    @Override
    public LoadDroneResponse loadDrone(LoadDroneRequest loadRequest) {
        Medication medication = Medication.builder()
                .name("rty")
                .weight(326)
                .image("Img893")
                .code("#$Ai5@")
        .build();
        Optional <Drone> existingDrone = droneRepository.findBySerialNumber(loadRequest.getSerialNumber());
        if (existingDrone.isEmpty()) {
            throw new RuntimeException("Drone specified does not exist");
        }

        if (medication == null) {
            throw new RuntimeException("Medication specified does not exist");
        }
        Drone drone = existingDrone.get();

        if (medication.getWeight() <= drone.getWeightLimit()) {
            throw new RuntimeException("The Drone cannot load more than the weight limit");
        }
        LoadDroneResponse loadDroneResponse = new LoadDroneResponse();
        loadDroneResponse.setMessage("Drone loaded successfully");
        loadDroneResponse.setMedication(medication);
        return loadDroneResponse;
    }


}
