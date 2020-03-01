package com.example.circulatinglibrary.repositories;

import com.example.circulatinglibrary.entities.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<Books,Integer> {
    Iterable<Books> findAllById(@Param("id") int id);
    Iterable<Books>findAllByNames(@Param("names") String names);
    Iterable<Books> findAllByAuthor(@Param("author")String author);

}
