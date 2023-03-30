//package asherflo.com.drone.service;
//
//import asherflo.com.drone.dto.request.DroneRegistrationRequest;
//import asherflo.com.drone.dto.request.LoadDroneRequest;
//import asherflo.com.drone.dto.response.DroneResponse;
//import asherflo.com.drone.dto.response.LoadDroneResponse;
//import asherflo.com.drone.exceptions.DroneException;
//import asherflo.com.drone.model.enums.DroneModel;
//import asherflo.com.drone.model.enums.DroneState;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class DroneServiceTest {
//    @Autowired
//    private DroneService droneService;
//
//    @Test
//    @DisplayName("Register a drone")
//    void testThatADroneCanBeRegister() throws DroneException {
//        DroneRegistrationRequest droneRegistrationRequest = new DroneRegistrationRequest();
//        droneRegistrationRequest.setSerialNumber("BIGY023");
//        droneRegistrationRequest.setDroneModel(DroneModel.LIGHTWEIGHT);
//        droneRegistrationRequest.setBatteryCapacity("95%");
//        droneRegistrationRequest.setDroneState(DroneState.LOADING);
//        DroneResponse response = droneService.registerDrone(droneRegistrationRequest);
//        assertNotNull(response);
//    }
//    @Test
//    @DisplayName("To load a drone")
//    void testThatLoadDroneWithMedication(){
//        LoadDroneRequest loadRequest = new LoadDroneRequest();
//        loadRequest.setName("Confident");
//        loadRequest.setCode("WER234");
//        loadRequest.setSerialNumber("WEyu798");
//        loadRequest.setWeight(239.30);
//        LoadDroneResponse loadDroneResponse = new LoadDroneResponse();
//        loadDroneResponse.setMessage("Drone loaded successfully");
//        assertNotNull(loadDroneResponse);
//
//    }
//}
//
