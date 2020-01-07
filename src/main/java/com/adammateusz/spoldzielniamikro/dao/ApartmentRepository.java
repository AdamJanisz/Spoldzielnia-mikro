package com.adammateusz.spoldzielniamikro.dao;

import com.adammateusz.spoldzielniamikro.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {
}
