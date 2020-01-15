package adammateusz.buildings.controller;

import adammateusz.buildings.domain.Apartment;
import adammateusz.buildings.domain.BuildingOwnerException;
import adammateusz.buildings.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("building/apartment")
public class ApartmentController {
    @Autowired
    ApartmentService apartmentService;

    @GetMapping("/")
    public List<Apartment> getApartmentLists() { return apartmentService.listAllApartments(); }
    @GetMapping("/{id}")
    public Apartment getApartment(@PathVariable long id){
        return apartmentService.getApartment(id);
    }
    @GetMapping("/building/{id}")
    public List<Apartment> getApartmentBills(@PathVariable long id){ return apartmentService.listBuildingApartments(id); }
 /*   @PostMapping("/build/{id}")
    public Apartment createNewApartment(@RequestBody Apartment apartment, @PathVariable long id){return apartmentService.addApartment(apartment,id);
    }*/
    @PostMapping("/")
    public void editApartment(@RequestBody Apartment apartment){ apartmentService.editApartment(apartment);}
    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable long id){
        apartmentService.removeApartment(id);
    }
    @PostMapping(path = "/{apartmentId}/tenant/{userId}")
    public ResponseEntity<?> apartmentAddTenant(@PathVariable("apartmentId") long apartmentId,
                                                @PathVariable("userId") long userId){
        try{
            apartmentService.addTenant(apartmentId,userId);
            return  ResponseEntity.ok().build();
        }catch(BuildingOwnerException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(),e);
        }
    }

}
