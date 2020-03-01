package com.example.circulatinglibrary.controller;

import com.example.circulatinglibrary.entities.Books;
import com.example.circulatinglibrary.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Books> getAll() {
        return bookService.getAll();
    }
    @GetMapping("/{id}")
    public Iterable<Books> getById(int id){
        return bookService.getById(id);
    }



}
