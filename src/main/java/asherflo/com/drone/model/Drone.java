package asherflo.com.drone.model;

import asherflo.com.drone.model.enums.DroneModel;
import asherflo.com.drone.model.enums.DroneState;
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
    @Column(length = 100)
    private  String serialNumber;
    @Enumerated(EnumType.STRING)
    private DroneModel droneModel;
    private int  weightLimit;
    private String batteryCapacity;
    @Enumerated(EnumType.STRING)
    private DroneState droneState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id")
    private Medication medication;

//    @OneToMany(mappedBy = "drone")
//    @JoinColumn(name="medication_id")
//    private List<Medication> medications;


}
