package com.example.circulatinglibrary.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "user",schema = "public")
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NotBlank(message = "Username is required!")
    @Column(name = "username")
    String username;
    @NotBlank(message = "Email is required!")
    @Column(name = "email")
    String email;
    @NotBlank(message = "Password is required!")
    @Column(name = "password")
    int password;

    public User( String username, String email , int password) {
        this.username=username;
        this.email=email;
        this.password=password;

    }
}
