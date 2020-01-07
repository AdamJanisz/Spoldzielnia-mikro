package adammateusz.buildings.service;

import adammateusz.buildings.domain.Appartment;


import java.util.List;

public interface AppartmentService {
    public Appartment addAppartment(Appartment appartment,long id);
    public Appartment editAppartment(Appartment appartment);
    public Appartment getAppartment(long id);
    public List<Appartment> listAllAppartments();
    public List<Appartment> listBuildingAppartments(long buildingId);
    public void removeAppartment(long id);
}
