package pdp.uz.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.rentcar.entity.Car;

import java.util.UUID;
@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
}
