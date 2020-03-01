package com.example.circulatinglibrary.services;

import com.example.circulatinglibrary.entities.Books;
import com.example.circulatinglibrary.entities.User;
import com.example.circulatinglibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }
    public Iterable<User> byId(int id){
        return  userRepository.findAllById(id);
    }
    public Iterable<User> byUsername(String username){
        return userRepository.findAllByUsername(username);
    }
    public Iterable<User> byEmail(String email){
        return userRepository.findAllByEmail(email);
    }

    public User create(User user){
        userRepository.save(user);
        return user;
    }
    public void delete(User user){
        userRepository.delete(user);
    }
    public User createIntial(){
        User newOne = new User("John","email@gmail.com",123456);
         userRepository.save(newOne);
         return newOne;
    }

}
