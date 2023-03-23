package asherflo.com.drone.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class AddMedicationRequest {
    private String name;
    private double weight;
    private String code;
    private String imageUrl;

}
