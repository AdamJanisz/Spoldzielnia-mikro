package adammateusz.buildings.controller;

import adammateusz.buildings.domain.Apartment;
import adammateusz.buildings.domain.Building;
import adammateusz.buildings.domain.BuildingOwnerException;
import adammateusz.buildings.domain.Owner;
import adammateusz.buildings.service.AppUserServiceClient;
import adammateusz.buildings.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("building")
public class BuildingController {



        @Autowired
        private BuildingService buildingService;

        @Autowired
        private AppUserServiceClient appUserServiceClient;

        @GetMapping("/")
        public List<Building> getBuildingLists() {return buildingService.findAll(); }
        @GetMapping("/{id}")
        public Building getBuilding(@PathVariable long id){
            return buildingService.findById(id);
        }
        @PostMapping("/")
        public Building createBuilding(@RequestBody Building building){ return buildingService.addBuilding(building); }
        @PutMapping("/")
        public void editBuilding(@RequestBody Building building){
            buildingService.editBuilding(building);
        }
        @RequestMapping(value = "/", method = RequestMethod.DELETE)
        public void deleteAppUser (@RequestParam long id){
            buildingService.removeBuilding(id);
        }
        @GetMapping("/appUser/")
        public List<Owner> getAppUserFromAppUserService(){
                return appUserServiceClient.getAppUsers();
        }
        @PostMapping(path = "/{buildingId}/appUser/{userId}")
        public ResponseEntity<?> buildingAddOwner(@PathVariable("buildingId") long buildingId,
                                                  @PathVariable("userId") long userId){
                try{
                        buildingService.addOwner(buildingId,userId);
                        return  ResponseEntity.ok().build();
                }catch(BuildingOwnerException e){
                        throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(),e);
                }
        }

        @GetMapping(value = "getOwnerAparments/{ownerId}")
        public List<Apartment> listOwnerApartments(@PathVariable long ownerId )
        {
                System.out.println("im in building "+ownerId);
                List<Building> buildings=buildingService.listManagerBuildings(ownerId);

                List<Apartment> apartmentsInAboveBuilding=new ArrayList<>();
                for(Building building: buildings)
                {
                        for(Apartment apartment:building.getApartmentList())
                        apartmentsInAboveBuilding.add(apartment);
                }

                System.out.println(apartmentsInAboveBuilding.size());

                return apartmentsInAboveBuilding;
        }


//@GetMapping("/loggedApartmentNumber")
//        public long getLoggedUserId(@RequestHeader("Authorization") String token)
//{
//        return appUserServiceClient.getLoggedAppUserApartmentNumber(token);
//}


}
