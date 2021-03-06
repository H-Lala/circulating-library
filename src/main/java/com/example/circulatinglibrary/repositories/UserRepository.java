package com.example.circulatinglibrary.repositories;

import com.example.circulatinglibrary.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    //Optional<User>findById(@Param("id") long id);
   // Iterable<User> findByEmail(@Param("email")String email);
    Optional<User> findByUsername(@Param("username")String username);
    //Iterable<User>findByUsernameAndPassword(@Param("username")String username,@Param("password") String password);

}
