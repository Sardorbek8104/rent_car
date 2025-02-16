package pdp.uz.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.rentcar.entity.AttachmentContent;

import java.util.UUID;
@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
}
