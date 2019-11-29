package com.adammateusz.spoldzielniamikro.controller;

import com.adammateusz.spoldzielniamikro.domain.AppUser;
import com.adammateusz.spoldzielniamikro.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("appUser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/")
    public List<AppUser> getAppUsersLists() {
        return appUserService.listAppUser();
    }
/*    @GetMapping("/{id}")
    public AppUser getAppUser(@RequestParam long id){
        return appUserService.getAppUser(id);
    }*/
    @PostMapping("/")
    public AppUser createAppUser(@RequestBody AppUser appUser){
        return appUserService.createAppUser(appUser);
    }
    @PutMapping("/")
    public void editAppUser(@RequestParam long id,@RequestBody AppUser appUser){
         appUserService.editAppUser(id,appUser);
    }
    @DeleteMapping("/")
    public void deleteAppUser (@RequestParam Long id){
        appUserService.removeAppUser(id);
    }


}
