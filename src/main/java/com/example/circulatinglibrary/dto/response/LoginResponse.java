package com.example.circulatinglibrary.dto.response;

import com.example.circulatinglibrary.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {
 private User user;
}
