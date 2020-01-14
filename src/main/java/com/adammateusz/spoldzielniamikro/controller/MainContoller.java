package com.adammateusz.spoldzielniamikro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class MainContoller {

    @GetMapping("/public")
    public String greeting1() {
        return "welcome publicznie";
    }

    @RolesAllowed({"ROLE_ADMIN"})
    @GetMapping("/admin")
    public String greeting() {
        return "im admin";
    }


}