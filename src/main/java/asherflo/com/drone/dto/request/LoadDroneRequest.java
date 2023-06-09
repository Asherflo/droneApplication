package asherflo.com.drone.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class LoadDroneRequest {
    private  String serialNumber;
    private double weight;
    private String code;

    private String name;
    private String image;

}
