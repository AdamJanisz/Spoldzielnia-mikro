package com.adammateusz.spoldzielniamikro.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Apartment {

    @Id
    private long id;
    private String apartmentNumber;

    @OneToMany(mappedBy = "apartment")
    List<AppUser> appUserList;


    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getApartmentNumber() { return apartmentNumber; }
    public void setApartmentNumber(String apartmentNumber) { this.apartmentNumber = apartmentNumber; }


    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", appUserList=" + appUserList +
                '}';
    }
}
