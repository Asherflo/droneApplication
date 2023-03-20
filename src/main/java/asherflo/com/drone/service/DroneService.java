package asherflo.com.drone.service;

import asherflo.com.drone.dto.request.DroneRegistrationRequest;
import asherflo.com.drone.dto.DroneResponse;

public interface DroneService {
    DroneResponse registerDrone (DroneRegistrationRequest droneRegistrationRequest);


}
