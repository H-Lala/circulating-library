package com.example.circulatinglibrary.controller;

import com.example.circulatinglibrary.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class UserController {
    @GetMapping("/login")
    public String getLogin() {
        return "login/index";
    }


}
