package com.adammateusz.spoldzielniamikro.controller;

import com.adammateusz.spoldzielniamikro.domain.AppUser;
import com.adammateusz.spoldzielniamikro.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;



@RestController
@RequestMapping("appUser")
public class AppUserController {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/")
   // @RolesAllowed({"ROLE_ADMIN"})
    public List<AppUser> getAppUsersLists() {
        return appUserService.listAppUser();
    }
/*    @GetMapping("/{id}")
    public AppUser getAppUser(@RequestParam long id){
        return appUserService.getAppUser(id);
    }*/
    @PostMapping("/")
    public AppUser createAppUser(@RequestBody AppUser appUser)
    {
     appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserService.createAppUser(appUser);
    }
    @PutMapping("/")
    public void editAppUser(@RequestParam long id,@RequestBody AppUser appUser){
         appUserService.editAppUser(id,appUser);
    }
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAppUser (@RequestParam long id){
        appUserService.removeAppUser(id);
    }

}
