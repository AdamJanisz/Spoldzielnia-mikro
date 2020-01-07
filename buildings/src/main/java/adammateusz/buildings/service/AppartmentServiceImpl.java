package adammateusz.buildings.service;

import adammateusz.buildings.dao.AppartmentRepository;
import adammateusz.buildings.dao.BuildingRepository;
import adammateusz.buildings.domain.Appartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppartmentServiceImpl implements AppartmentService {
    @Autowired
    AppartmentRepository appartmentRepository;
    @Autowired
    BuildingRepository buildingRepository;

    @Transactional
    public Appartment addAppartment(Appartment appartment,long id) {
        appartment.setAppartmentAddress(buildingRepository.findByIdOrderById(id));
       return appartmentRepository.save(appartment);
    }

    @Transactional
    public Appartment editAppartment(Appartment appartment) {
        return appartmentRepository.save(appartment);
    }

    @Transactional
    public Appartment getAppartment(long id) {
        return appartmentRepository.findById(id);
    }

    @Transactional
    public List<Appartment> listAllAppartments() {
        return appartmentRepository.findAll();
    }

    @Transactional
    public List<Appartment> listBuildingAppartments(long buildingId) {
        return appartmentRepository.findAllByAppartmentAddress_IdOrderByAppartmentNumberAsc(buildingId);
    }

    @Transactional
    public void removeAppartment(long id) {
        appartmentRepository.delete(appartmentRepository.findById(id));
    }
}
