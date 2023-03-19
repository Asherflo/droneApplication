package asherflo.com.drone.service;

import asherflo.com.drone.controller.requests.DroneRegistrationRequest;
import asherflo.com.drone.dto.DroneResponse;
import asherflo.com.drone.model.Drone;
import asherflo.com.drone.model.enums.Model;
import asherflo.com.drone.model.enums.State;
import asherflo.com.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DroneServiceImpl implements DroneService{
    @Autowired
    private DroneRepository droneRepository;
    @Override
    public DroneResponse registerDrone(DroneRegistrationRequest droneRegistrationRequest) {

        Drone drone = Drone.builder()
                .state(State.LOADING)
                .batteryCapacity(droneRegistrationRequest.getBatteryCapacity())
                .serialNumber(droneRegistrationRequest.getSerialNumber())
                .weightLimit(droneRegistrationRequest.getWeightLimit())
                .model(Model.HEAVYWEIGHT)
                .build();
        Drone savedDrone = droneRepository.save(drone);
        DroneResponse response = new DroneResponse();
        response.setMessage("Drone successfully registered");
        response.setDrone(savedDrone);
        return response;

    }
}
