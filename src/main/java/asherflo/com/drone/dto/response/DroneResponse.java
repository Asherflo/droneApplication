package asherflo.com.drone.dto.response;

import asherflo.com.drone.model.Drone;
import asherflo.com.drone.model.Medication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class DroneResponse {
    private  String serialNumber;

    private String droneModel;
    private  double weightLimit;

    private double loadedWeight;
    private String batteryCapacity;
    private String droneState;

    private List<Medication> medications ;
}