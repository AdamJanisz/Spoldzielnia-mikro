package com.adammateusz.spoldzielniamikro.config;

import com.adammateusz.spoldzielniamikro.domain.AppUser;
import com.adammateusz.spoldzielniamikro.domain.AppUserRole;
import com.adammateusz.spoldzielniamikro.service.AppUserRoleService;
import com.adammateusz.spoldzielniamikro.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
//
//@Profile("!test")
//@Component
//public class PrepareDBConfig {
//    @Autowired
//    private AppUserService appUserService;
//
//    @Autowired
//    AppUserRoleService appUserRoleService;
//
//
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void contextRefreshedEvent() {
//        AppUser appUser;
//        appUser = prepareAppUser(appUserRoleService.findByRoleName("ROLE_ADMIN"),"admin1", "admin2",
//                "admin1",passwordEncoder.encode("admin2"),"admin@edu.p.lodz.pl");
//        appUserService.createAppUser(appUser);
//
//        appUser = prepareAppUser(appUserRoleService.findByRoleName("ROLE_MANAGER"),"manager1","manager1",
//                "manager1",passwordEncoder.encode("manager2"),"manager@edu.p.lodz.pl");
//        appUserService.createAppUser(appUser);
//
//        appUser = prepareAppUser(appUserRoleService.findByRoleName("ROLE_USER"),"user1", "user2",
//                "user1",passwordEncoder.encode("user2"), "user@edu.p.lodz.pl");
//        appUserService.createAppUser(appUser);
//
//    }
//
//    private AppUser prepareAppUser(AppUserRole role, String firstName, String lastName, String username, String password, String email) {
//        AppUser appUser = new AppUser();
//        appUser.setFirstName(firstName);
//        appUser.setLastName(lastName);
//        appUser.setEmail(email);
//        appUser.setUsername(username);
//        appUser.setPassword(password);
//        Set<AppUserRole> roleSet=new HashSet<>();
//        roleSet.add(role);
//        appUser.setAppUserRole(roleSet);
//        return appUser;
//    }
//
//
//
//
//}
