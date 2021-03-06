package com.example.circulatinglibrary.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class UserDetail implements UserDetails {
    private final  long id;
    private final String username;
    private final String password;
    private final String roles [];

    public UserDetail(long id, String username, String password, String ... roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles=roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles)
                .map(s->"ROLE_" +s)
                .map(s->(GrantedAuthority)()->s)
                .collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
