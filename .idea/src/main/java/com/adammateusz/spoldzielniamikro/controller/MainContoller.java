package com.adammateusz.spoldzielniamikro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainContoller {

    @GetMapping("/")
    public String greeting1() {
        return "mainBody";
    }

    @GetMapping("/body")
    public String greeting() {
        return "2body";
    }


}