package adammateusz.buildings.service;

import adammateusz.buildings.domain.Building;

import java.util.List;

public interface BuildingService {
    List<Building> findAll();
    Building findById(long id);
    Building addBuilding(Building building);
    List <Building> listManagerBuildings(long id);
    List <Building> listManagerBuildingsByUsername(String username);
    Building editBuilding(Building building);
    void removeBuilding(long id);
    void addOwner(long buildingID,long appUserID);


}
