package adammateusz.buildings.dao;

import adammateusz.buildings.domain.Appartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppartmentRepository extends JpaRepository<Appartment,Long> {
    List<Appartment> findAllByAppartmentAddress_IdOrderByAppartmentNumberAsc(long id);
    Appartment findById(long id);
}
