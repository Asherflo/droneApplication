package asherflo.com.drone.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DroneMedicationLoadResponse {
    private String serialNumber;

    List<MedicationDto> medicationDtoList;
}
