package com.example.circulatinglibrary.repositories;

import com.example.circulatinglibrary.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    Iterable<User>findById(@Param("id") int id);
   // Iterable<User>findByUsername2(@Param("username") String username);
    Iterable<User> findByEmail(@Param("email")String email);
    Optional<User> findByUsername(@Param("username")String username);

}
