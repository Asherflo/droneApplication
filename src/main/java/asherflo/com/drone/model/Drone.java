package asherflo.com.drone.model;

import asherflo.com.drone.model.enums.Model;
import asherflo.com.drone.model.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Drones")
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

    @OneToMany(mappedBy = "drone")
    @JoinColumn(name="medication_id")
    private Set<Medication> medications;


}
