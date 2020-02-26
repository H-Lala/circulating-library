package com.example.circulatinglibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class TemplateController {
    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("home")
    public String getHomeView() {
        return "home";
    }

    @GetMapping("registration")
    public String getRegistrationView() {
        return "registration";
    }

    @GetMapping("profile")
    public String getProfileView() {
        return "profile";
    }
}
