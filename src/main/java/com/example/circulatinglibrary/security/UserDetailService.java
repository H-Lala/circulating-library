package com.example.circulatinglibrary.security;

import com.example.circulatinglibrary.entities.User;
import com.example.circulatinglibrary.repositories.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Configuration
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public static UserDetails mapper(User user) {
        return new UserDetail(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).
                map(UserDetailService::mapper)
                .orElseThrow(()->new UsernameNotFoundException(
                        String.format("User not found")
                ));

    }
}
