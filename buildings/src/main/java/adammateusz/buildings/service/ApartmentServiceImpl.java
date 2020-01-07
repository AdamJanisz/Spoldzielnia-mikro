package adammateusz.buildings.service;

import adammateusz.buildings.dao.ApartmentRepository;
import adammateusz.buildings.dao.BuildingRepository;
import adammateusz.buildings.dao.OwnerRepository;
import adammateusz.buildings.domain.Apartment;
import adammateusz.buildings.domain.Building;
import adammateusz.buildings.domain.BuildingOwnerException;
import adammateusz.buildings.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    @Autowired
    ApartmentRepository apartmentRepository;
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    AppUserServiceClient appUserServiceClient;
    @Autowired
    OwnerRepository ownerRepository;

    @Transactional
    public Apartment addApartment(Apartment apartment, long id) {
        apartment.setApartmentAddress(buildingRepository.findById(id).get());
       return apartmentRepository.save(apartment);
    }

    @Transactional
    public Apartment editApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Transactional
    public Apartment getApartment(long id) {
        return apartmentRepository.findById(id).get();
    }

    @Transactional
    public List<Apartment> listAllApartments() {
        return apartmentRepository.findAll();
    }

    @Transactional
    public List<Apartment> listBuildingApartments(long buildingId) {
        return apartmentRepository.findAllByApartmentAddress_IdOrderByApartmentNumberAsc(buildingId);
    }

    @Transactional
    public void removeApartment(long id) {
        apartmentRepository.delete(apartmentRepository.findById(id).get());
    }

    @Transactional
    public void addTenant(long apartmentID, long appUserID) {

        Apartment apartment=apartmentRepository.findById(apartmentID).orElseThrow(()-> new BuildingOwnerException("Apartment does not exist!"));
        Owner tenant = appUserServiceClient.getAppUser(appUserID);
        if(StringUtils.isEmpty(tenant.getId()))throw(new NullPointerException("appUser does not exist"));

        apartment.setTenant(tenant);
        apartmentRepository.save(apartment);

    }
}
