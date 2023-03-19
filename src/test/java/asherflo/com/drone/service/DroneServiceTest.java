package asherflo.com.drone.service;

import asherflo.com.drone.controller.requests.DroneRegistrationRequest;
import asherflo.com.drone.dto.DroneResponse;
import asherflo.com.drone.model.enums.Model;
import asherflo.com.drone.model.enums.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DroneServiceTest {
    @Autowired
    private DroneService droneService;

    @Test
    @DisplayName("Register a drone")
    void testThatADroneCanBeRegister(){
        DroneRegistrationRequest droneRegistrationRequest = new DroneRegistrationRequest();
        droneRegistrationRequest.setSerialNumber("BIG023");
        droneRegistrationRequest.setModel(Model.LIGHTWEIGHT);
        droneRegistrationRequest.setWeightLimit(386);
        droneRegistrationRequest.setBatteryCapacity("95%");
        droneRegistrationRequest.setState(State.LOADING);
        DroneResponse response = droneService.registerDrone(droneRegistrationRequest);
        assertNotNull(response);


    }

}