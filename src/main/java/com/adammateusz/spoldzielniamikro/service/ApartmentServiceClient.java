package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.domain.Apartment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@FeignClient(name="BUILDINGS-SERVICE")
public interface ApartmentServiceClient {

//        @GetMapping(value = "/apartment/")
//        List<Apartment> getApartment();

//        @GetMapping(value = "/apartment/{id}")
//        Apartment getApartment(@PathVariable Long id);


        @PostMapping(value = "building/{buildingId}/appUser/{userId}")
        public ResponseEntity<?> buildingAddOwner(@PathVariable("buildingId") long buildingId,
                                                  @PathVariable("userId") long userId);


        @GetMapping(value = "building/getOwnerAparments/{ownerId}")
        List<Apartment> getApartments(@PathVariable long ownerId);
}
