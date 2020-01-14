package com.adammateusz.spoldzielniamikro.controller;

import com.adammateusz.spoldzielniamikro.domain.AppUser;
import com.adammateusz.spoldzielniamikro.domain.AppUserRole;
import com.adammateusz.spoldzielniamikro.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.Null;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("appUser")
public class AppUserController {


    @Autowired
    private AppUserService appUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public AppUser createAppUser(@RequestBody AppUser appUser)
    {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserService.createAppUser(appUser);
    }

    @GetMapping("/getUser/{username}")
    public Set<AppUserRole> getRolesByUsername(@PathVariable String username)
    {
        try{
            return appUserService.findByLogin(username).getAppUserRole();
        }
        catch (NullPointerException ex)
        { }


        return Collections.emptySet();
    }


    @GetMapping("/")
   @RolesAllowed({"ROLE_ADMIN"})
    public List<AppUser> getAppUsersLists() {
        return appUserService.listAppUser();
    }
    @GetMapping("/{id}")
    public AppUser getAppUser(@PathVariable long id){
        return appUserService.getAppUser(id);
    }


    @CrossOrigin
    @PutMapping("/")
    public void editAppUser(@RequestParam long id,@RequestBody AppUser appUser){
         appUserService.editAppUser(id,appUser);
    }


    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAppUser (@RequestParam long id){
        appUserService.removeAppUser(id);
    }

}
