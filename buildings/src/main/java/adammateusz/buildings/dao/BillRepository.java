package adammateusz.buildings.dao;

import adammateusz.buildings.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    Bill findById(long id);
    List<Bill> findAllByApartment_IdOrderByDate(long id);
    List<Bill> findAllByApartment_ApartmentAddress_Owner_IdOrderByDate(long id);


}
