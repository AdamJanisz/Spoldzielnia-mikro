package adammateusz.buildings.dao;

import adammateusz.buildings.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {

   Optional<Building> findById(long id);
   Building findByIdOrderById(long id);
   List<Building> findAllByOwner_IdOrderByCityAsc(long id);
}
