package com.example.circulatinglibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterResponse {
    private String message;
    public static  RegisterResponse OK(){
        return  new RegisterResponse("OK");
    }
    public static RegisterResponse alreadyExists(){
        return new RegisterResponse("" +
                "Error: User Already exists");
    }
}
