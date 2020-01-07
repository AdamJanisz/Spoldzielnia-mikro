package adammateusz.buildings.dao;

import adammateusz.buildings.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
