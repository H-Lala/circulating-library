package com.example.circulatinglibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ManagementController {
    @GetMapping("/management")
    public String getManagement() {
        return "management/index";
    }
}
