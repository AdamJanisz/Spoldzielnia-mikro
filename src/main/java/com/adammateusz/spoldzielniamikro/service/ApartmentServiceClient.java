package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.domain.Apartment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="BUILDINGS-SERVICE")
public interface ApartmentServiceClient {

        @GetMapping(value = "/apartment/")
        List<Apartment> getApartment();

        @GetMapping(value = "/apartment/{id}")
        Apartment getApartment(@PathVariable Long id);
}
