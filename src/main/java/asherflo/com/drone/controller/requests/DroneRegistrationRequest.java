package asherflo.com.drone.controller.requests;

import asherflo.com.drone.model.enums.Model;
import asherflo.com.drone.model.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DroneRegistrationRequest {
    private  String serialNumber;
    private Model model;
    private int  weightLimit;
    private String batteryCapacity;
    private State state;

}
