package asherflo.com.drone.controller;

import asherflo.com.drone.dto.request.LoadDroneRequest;
import asherflo.com.drone.dto.response.ApiResponse;
import asherflo.com.drone.dto.response.DroneResponse;
import asherflo.com.drone.dto.request.DroneRegistrationRequest;
import asherflo.com.drone.dto.response.LoadDroneResponse;
import asherflo.com.drone.exceptions.DroneException;
import asherflo.com.drone.service.DroneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/drone")
public class DroneController {
    @Autowired
    private  DroneService droneService;



    @PostMapping("/register")
    public ResponseEntity<?> registerDrone(@RequestBody DroneRegistrationRequest droneRegistrationRequest){
        DroneResponse droneResponse = droneService.registerDrone(droneRegistrationRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("Drone successfully registered")
                .data(droneResponse)
                .build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PostMapping("/load")
    public  ResponseEntity<?>loadDroneWithMedication(@Valid @RequestBody LoadDroneRequest loadDroneRequest) throws DroneException {
        LoadDroneResponse loadDroneResponse = droneService.loadDrone(loadDroneRequest);
        return  new ResponseEntity<>(loadDroneResponse,HttpStatus.CREATED);
    }
}
