package asherflo.com.drone.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private  String status;
    private String message;
    private Object data;
    private int result;

}
