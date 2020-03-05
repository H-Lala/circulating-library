package com.example.circulatinglibrary.security.service;

import com.example.circulatinglibrary.entities.User;
import com.example.circulatinglibrary.repositories.UserRepository;
import com.example.circulatinglibrary.security.UserDetail;
import com.example.circulatinglibrary.security.jwt.Const;
import com.example.circulatinglibrary.security.jwt.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenService tokenService;
  private final UserRepository userRepository;
  private final PasswordEncoder encoder;

    public AuthService(AuthenticationManager authenticationManager, JwtTokenService tokenService, UserRepository userRepository, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    public  boolean register(String username ,String email , String password){
        Optional<User> found = userRepository.findByUsername(username);
        if(!found.isPresent()){
            userRepository.save(new User(username,email,encoder.encode(password)));
        }
        return !found.isPresent();
    }

    public Optional<String> login(String username , String password){//, boolean remember){
        return Optional.of(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        )).filter(Authentication::isAuthenticated)
                .map(a->{
                    SecurityContextHolder.getContext().setAuthentication(a);
                    return a;
                })
                .map(a->(UserDetail) a.getPrincipal())
                .map(userDetail -> tokenService.generateToken(userDetail.getId()))//,remember))
                .map(t-> Const.AUTH_BEARER+t);
    }
}
