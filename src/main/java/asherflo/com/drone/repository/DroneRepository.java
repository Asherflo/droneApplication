package asherflo.com.drone.repository;

import asherflo.com.drone.model.Drone;
import asherflo.com.drone.model.enums.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    Drone findBySerialNumber(String id);
//    List<Drone> findAllByState( DroneState droneState);
}
