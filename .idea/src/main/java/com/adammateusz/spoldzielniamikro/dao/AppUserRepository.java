package com.adammateusz.spoldzielniamikro.dao;

import com.adammateusz.spoldzielniamikro.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findByLastName(String lastName);
    AppUser findById(long id);
    AppUser findByLogin(String login);

}
