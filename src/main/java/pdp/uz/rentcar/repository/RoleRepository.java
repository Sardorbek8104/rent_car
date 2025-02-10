package pdp.uz.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.rentcar.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
