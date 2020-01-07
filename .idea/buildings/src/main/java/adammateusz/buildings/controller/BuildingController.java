package adammateusz.buildings.controller;

import adammateusz.buildings.domain.AppUser;
import adammateusz.buildings.domain.Building;
import adammateusz.buildings.service.AppUserServiceClient;
import adammateusz.buildings.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
        @GetMapping("")
        public Building getBuilding(@RequestParam long id){
            return buildingService.findById(id);
        }
        @PostMapping("/")
        public Building createAppUser(@RequestBody Building building){ return buildingService.addBuilding(building); }
        @PutMapping("/")
        public void editAppUser(@RequestBody Building building){
            buildingService.editBuilding(building);
        }
        @RequestMapping(value = "/", method = RequestMethod.DELETE)
        public void deleteAppUser (@RequestParam long id){
            buildingService.removeBuilding(id);
        }

        @GetMapping("/appUser/")
        public List<AppUser> getAppUserFromAppUserService(){
                return appUserServiceClient.getAppUsers();
        }




}
