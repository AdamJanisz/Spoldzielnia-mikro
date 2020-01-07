package com.adammateusz.spoldzielniamikro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Apartment {

    @Id
    private long id;
    private String apartmentNumber;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getApartmentNumber() { return apartmentNumber; }
    public void setApartmentNumber(String apartmentNumber) { this.apartmentNumber = apartmentNumber; }
}
