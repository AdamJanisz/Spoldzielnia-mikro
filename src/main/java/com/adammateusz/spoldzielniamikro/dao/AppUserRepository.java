package com.adammateusz.spoldzielniamikro.dao;

import com.adammateusz.spoldzielniamikro.domain.Apartment;
import com.adammateusz.spoldzielniamikro.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findByLastName(String lastName);
    AppUser findById(long id);
    AppUser findByUsername(String username);

    @Transactional
    @Query(value = "select * from appuser, app_user_apartment WHERE app_user_apartment.apartment_id=:apartmentId and appuser.id=app_user_apartment.user_id;",nativeQuery = true)
    List<AppUser> appUsersForAparment(@Param("apartmentId") long apartmentId);

}
