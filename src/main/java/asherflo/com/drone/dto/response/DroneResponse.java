package asherflo.com.drone.dto.response;

import asherflo.com.drone.model.Drone;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DroneResponse {
    private String message;
    private Drone drone;
}
