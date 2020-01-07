package adammateusz.buildings.service;

import adammateusz.buildings.domain.Apartment;


import java.util.List;

public interface ApartmentService {
    public Apartment addApartment(Apartment apartment, long id);
    public Apartment editApartment(Apartment apartment);
    public Apartment getApartment(long id);
    public List<Apartment> listAllApartments();
    public List<Apartment> listBuildingApartments(long buildingId);
    public void removeApartment(long id);
    void addTenant(long apartmentID,long appUserID);
}
