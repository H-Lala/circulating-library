package com.example.circulatinglibrary.services;

import com.example.circulatinglibrary.entities.Books;
import com.example.circulatinglibrary.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

   private final BooksRepository booksRepository;


    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Iterable<Books> getAll() {
        List<Books> booksSet = new ArrayList<>();
        booksRepository.findAll().forEach(booksSet::add);
        return booksSet;
    }

    public Iterable<Books> getById(int id) {
        return booksRepository.findAllById(id);
    }
    public Iterable<Books> getByNames(String names){
        return booksRepository.findAllByNames(names);
    }
    public Iterable<Books> getByAuthor(String author){
        return booksRepository.findAllByAuthor(author);
    }
}
