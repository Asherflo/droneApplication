package asherflo.com.drone.controller;

import asherflo.com.drone.dto.request.LoadDroneRequest;
import asherflo.com.drone.dto.response.ApiResponse;
import asherflo.com.drone.dto.response.DroneResponse;
import asherflo.com.drone.dto.request.DroneRegistrationRequest;
import asherflo.com.drone.dto.response.LoadDroneResponse;
import asherflo.com.drone.dto.response.MedicationResponse;
import asherflo.com.drone.exceptions.DroneException;
import asherflo.com.drone.service.DroneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/drone")
public class DroneController {
    @Autowired
    private  final DroneService droneService;



    @PostMapping("/register")
    public ResponseEntity<?> registerDrone(@RequestBody DroneRegistrationRequest droneRegistrationRequest) throws DroneException {
        DroneResponse droneResponse = droneService.registerDrone(droneRegistrationRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(200)
                .data(droneResponse)
                .successful(true)
                .build();
        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PostMapping("/load")
    public  ResponseEntity<?>loadDroneWithMedication(@RequestBody LoadDroneRequest loadDroneRequest) throws DroneException {
        LoadDroneResponse loadDroneResponse = droneService.loadDrone(loadDroneRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(200)
                .successful(true)
                .data(loadDroneResponse)
                .build();
        return  new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }
    @GetMapping("/view")
    public ResponseEntity<?> checkLoadedMedication(@RequestParam String serialNumber) throws DroneException{
        List<MedicationResponse> response = droneService.checkLoadedMedications(serialNumber);
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(302)
                .data(response)
                .successful(true)
                .build();
        return  new ResponseEntity<>(apiResponse,HttpStatus.FOUND);

    }

    @GetMapping("/view_available")
    public ResponseEntity <?> viewAvailableDrone(){
        List<DroneResponse> response = droneService.viewAvailableDrone();
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(302)
                .data(response)
                .successful(true)
                .build();
        return  new ResponseEntity<>(apiResponse,HttpStatus.FOUND);

    }

    @GetMapping("/battery")
    public ResponseEntity<?> batteryCheck(@RequestParam String serialNumber) throws DroneException {
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(302)
                .data(droneService.batteryCheck(serialNumber))
                .successful(true)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.FOUND);
    }


}
