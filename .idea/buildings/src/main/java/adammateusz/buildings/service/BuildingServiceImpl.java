package adammateusz.buildings.service;

import adammateusz.buildings.dao.BuildingRepository;
import adammateusz.buildings.domain.Building;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    @Transactional
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    @Transactional
    public Building findById(long id) {
        return buildingRepository.findById(id);
    }

    @Transactional
    public Building addBuilding(Building building) {
        return buildingRepository.save(building);
    }

    @Transactional
    public List<Building> listManagerBuildings(long id) {
        return buildingRepository.findAllByOwner_IdOrderByCityAsc(id);
    }

    @Transactional
    public Building editBuilding(Building building) {
        Building oldBuilding=buildingRepository.findById(building.getId());

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
        buildingRepository.delete(buildingRepository.findById(id));
    }
}
