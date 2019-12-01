package com.adammateusz.spoldzielniamikro.dao;

import com.adammateusz.spoldzielniamikro.domain.Bill;
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

    @Transactional
    @Query(value = "select * from bill b where b.app_user_id=:userId",nativeQuery = true)
    List<Bill> billsForUser(@Param("userId") long userId);



}
