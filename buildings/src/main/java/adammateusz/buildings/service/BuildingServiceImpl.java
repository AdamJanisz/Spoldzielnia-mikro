package adammateusz.buildings.service;

import adammateusz.buildings.dao.BuildingRepository;
import adammateusz.buildings.dao.OwnerRepository;
import adammateusz.buildings.domain.Building;
import adammateusz.buildings.domain.BuildingOwnerException;
import adammateusz.buildings.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    AppUserServiceClient appUserServiceClient;
    @Autowired
    OwnerRepository ownerRepository;

    @Transactional
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    @Transactional
    public Building findById(long id) {
        return buildingRepository.findById(id).orElseThrow(()->new NullPointerException("Building does not exist"));
    }

    @Transactional
    public Building addBuilding(Building building) {
        ownerRepository.saveAndFlush(building.getOwner());
        //building.setOwner(building.getOwner());
        return buildingRepository.save(building);
    }

    @Override
    public List<Building> listManagerBuildings(long id) {
        return buildingRepository.findAllByOwner_IdOrderByCityAsc(id);
    }

    @Override
    public List<Building> listManagerBuildingsByUsername(String username) {
        return buildingRepository.findAllByOwner_Username(username);
    }


    @Transactional
    public Building editBuilding(Building building) {
        Building oldBuilding=buildingRepository.findById(building.getId()).orElseThrow(()->new NullPointerException("Building does not exist"));

        oldBuilding.setCity(building.getCity());
        oldBuilding.setStreet(building.getStreet());
        oldBuilding.setBuildingNumber(building.getBuildingNumber());
        oldBuilding.setColdWaterPrice(building.getColdWaterPrice());
        oldBuilding.setHotWaterPrice(building.getHotWaterPrice());
        oldBuilding.setElectricityPrice(building.getElectricityPrice());
        oldBuilding.setSewagePrice(building.getSewagePrice());
        oldBuilding.setMaintenanceFundPrice(building.getMaintenanceFundPrice());
        oldBuilding.setOwner(building.getOwner());
        return buildingRepository.save(oldBuilding);
    }

    @Transactional
    public void removeBuilding(long id) {
        buildingRepository.delete(buildingRepository.findById(id).orElseThrow(()->new NullPointerException("Building does not exist")));
    }

    @Transactional
    public void addOwner(long buildingID, long appUserID) {
        Building building=buildingRepository.findById(buildingID).orElseThrow(()-> new BuildingOwnerException("Building does not exist!"));

        Owner owner = appUserServiceClient.getAppUser(appUserID);
        if(StringUtils.isEmpty(owner.getId()))throw(new NullPointerException("appUser does not exist"));
        ownerRepository.saveAndFlush(owner);


        building.setOwner(owner);
        buildingRepository.save(building);

    }
}
