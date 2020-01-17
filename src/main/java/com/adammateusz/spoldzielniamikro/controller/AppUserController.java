package com.adammateusz.spoldzielniamikro.controller;

import com.adammateusz.spoldzielniamikro.domain.Apartment;
import com.adammateusz.spoldzielniamikro.domain.AppUser;
import com.adammateusz.spoldzielniamikro.domain.AppUserRole;
import com.adammateusz.spoldzielniamikro.service.ApartmentServiceClient;
import com.adammateusz.spoldzielniamikro.service.AppUserRoleService;
import com.adammateusz.spoldzielniamikro.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.Null;
import java.util.*;


@RestController
@RequestMapping("appUser")
public class AppUserController {


    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRoleService appUserRoleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ApartmentServiceClient apartmentServiceClient;

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
   @RolesAllowed({"ROLE_ADMIN","ROLE_MANAGER"})
    public List<AppUser> getAppUsersLists()
    {
        AppUser appUser=appUserService.findLoggedAppUser();
        for(AppUserRole role: appUser.getAppUserRole())
        {
            if(role.getRole().equals("ROLE_MANAGER"))
            {
                List<Apartment> apartments=apartmentServiceClient.getApartments(appUser.getId());


                List<AppUser> appUsersToManage=new ArrayList<>();
                for(Apartment apartment: apartments)
                {

                    for(AppUser appUser1: appUserService.findByAparmentId(apartment.getId()))
                  {
                       appUsersToManage.add(appUser1);
                   }

                }
                return appUsersToManage;
            }
        }

        return appUserService.listAppUser();
    }

    @PutMapping(value="/makeUserManager")
    public void buildingAddOwner(@RequestBody String username){
        AppUser appUser=appUserService.findByLogin(username);
        appUser.setAppUserRole(Collections.emptySet());
        Set<AppUserRole> appUserRoles=new HashSet<>();
        appUserRoles.add(appUserRoleService.findByRole("ROLE_MANAGER"));
        appUser.setAppUserRole(appUserRoles);
        appUserService.editAppUser(appUser.getId(),appUser);
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

    @GetMapping("/loggedApartmentNumber/{username}")
    public Set<Apartment> getLoggedApartmentNumber(@PathVariable String username)
    {
        try{
            AppUser appUser=appUserService.findByLogin(username);
            Set<Apartment> apSet=new HashSet<>();
            apSet.add(appUser.getApartment());
            return apSet;
        }
        catch (Exception ex)
        {

        }
return Collections.EMPTY_SET;
    }


    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAppUser (@RequestParam long id){
        appUserService.removeAppUser(id);
    }

}
