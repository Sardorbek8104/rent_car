package pdp.uz.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.rentcar.entity.Notification;

import java.util.UUID;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}
