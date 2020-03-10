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
@Table(name = "user", schema = "public")
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @NotBlank(message = "Username is required!")
    @Column(name = "username")
    String username;
    @NotBlank(message = "Email is required!")
    @Column(name = "email")
    String email;
    @NotBlank(message = "Password is required!")
    @Column(name = "password")
    String password;


    String roles;

  @Transient
  public String ROLES_DELIMITER = ":";
    public User(String username, String email, String password, String... roles) {
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public String[] getRoles() {
        if (this.roles == null || this.roles.isEmpty()
        ) return new String[]{};
        return this.roles.split(ROLES_DELIMITER);
    }
    public void setRoles(String[] roles){
        this.roles=String.join(ROLES_DELIMITER,roles);
    }


}
