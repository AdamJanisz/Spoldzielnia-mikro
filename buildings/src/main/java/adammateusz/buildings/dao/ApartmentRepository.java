package adammateusz.buildings.dao;

import adammateusz.buildings.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<Apartment,Long> {
    List<Apartment> findAllByApartmentAddress_IdOrderByApartmentNumberAsc(long id);

    Optional<Apartment> findById(Long id);

   // Apartment findById(long id);
}
