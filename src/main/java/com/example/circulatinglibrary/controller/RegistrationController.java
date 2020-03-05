package com.example.circulatinglibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class RegistrationController {
    @GetMapping("/registration")
    public String getRegistration(){
        return "registration/index";
    }
}
