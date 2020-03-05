package com.example.circulatinglibrary.controller;

import com.example.circulatinglibrary.entities.Books;
import com.example.circulatinglibrary.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class BookController {
     @GetMapping("/home")
     public String getHome(){
         return "home/index";
     }



}
