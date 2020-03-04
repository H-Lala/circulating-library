package com.example.circulatinglibrary.controller;

import com.example.circulatinglibrary.entities.Books;
import com.example.circulatinglibrary.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("home")
public class BookController {
     @GetMapping("index")
     public String getHome(){
         return "home/index";
     }



}
