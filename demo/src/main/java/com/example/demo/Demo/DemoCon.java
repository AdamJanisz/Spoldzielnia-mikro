package com.example.demo.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class DemoCon {

    @GetMapping("/public")
    public String welcomePublic() { return "welcome public/guest";}

    @RolesAllowed({"ROLE_ADMIN"})
    @GetMapping("/admin")
    public String welcomeAdmin() { return  "welcome admin";}

    @RolesAllowed({"ROLE_USER"})
    @GetMapping("/user")
    public String welcomeUser() { return  "welcome user";}
}
