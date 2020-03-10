package com.example.circulatinglibrary.security.service;

import com.example.circulatinglibrary.dto.request.LoginRequest;
import com.example.circulatinglibrary.dto.request.LogoutRequest;
import com.example.circulatinglibrary.dto.request.RegisterRequest;
import com.example.circulatinglibrary.dto.response.LoginResponse;
import com.example.circulatinglibrary.dto.response.LogoutResponse;
import com.example.circulatinglibrary.dto.response.RegisterResponse;
import com.example.circulatinglibrary.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;

    private final UserService userService;

    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService=userService;
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        log.info(request);
        log.info("login function in auth control");
        return authService
                .login(request.getUsername(),request.getPassword(),request.isRemember())
                // you have to fix this section
                .map(t -> new LoginResponse(userService.byUsername(request.getUsername()).get(),t))
               // .map(new LoginResponse("OK"))
                .orElse(new LoginResponse(null,null));



    }
    @PostMapping("/logout")
    public LogoutResponse logout(@RequestBody LogoutRequest request){
        log.info(request);
        return new LogoutResponse("POST:/logout:couldn't be implemented by using this approach");
    }
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request){
        log.info(request);
        boolean result = authService.register(request.getUsername(), request.getEmail(), request.getPassword());
        return result ? RegisterResponse.OK() : RegisterResponse.alreadyExists();
    }
}
