package asherflo.com.drone.service;

import asherflo.com.drone.dto.request.DroneRegistrationRequest;
import asherflo.com.drone.dto.DroneResponse;
import asherflo.com.drone.model.Drone;
import asherflo.com.drone.model.Medication;
import asherflo.com.drone.model.enums.DroneModel;
import asherflo.com.drone.model.enums.DroneState;
import asherflo.com.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DroneServiceImpl implements DroneService{
    @Autowired
    private DroneRepository droneRepository;
    @Override
    public DroneResponse registerDrone(DroneRegistrationRequest droneRegistrationRequest) {

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
    public LoadDroneResponse loadDrone(LoadDroneRequest loadDroneRequest) {
        return null;
    }


}
