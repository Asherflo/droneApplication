package asherflo.com.drone.model;

import asherflo.com.drone.model.enums.Model;
import asherflo.com.drone.model.enums.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Drones")
@Builder
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String serialNumber;
    @Enumerated(EnumType.STRING)
    private Model model;
    private int  weightLimit;
    private String batteryCapacity;
    @Enumerated(EnumType.STRING)
    private State state;

//    @OneToMany(mappedBy = "drone")
//    @JoinColumn(name="medication_id")
//    private List<Medication> medications;


}
