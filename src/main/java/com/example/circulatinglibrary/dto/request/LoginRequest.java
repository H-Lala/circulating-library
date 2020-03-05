package com.example.circulatinglibrary.dto.request;

import lombok.*;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class LoginRequest {
    private String username;
    private String password;
   // private boolean remember;
}
