package com.example.circulatinglibrary.repositories;

import com.example.circulatinglibrary.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    Iterable<User>findAllById(@Param("id") int id);
    Iterable<User>findAllByUsername(@Param("username") String username);
    Iterable<User> findAllByEmail(@Param("email")String email);

}
