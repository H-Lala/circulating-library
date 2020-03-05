package com.example.circulatinglibrary.security;

import com.example.circulatinglibrary.mvc.ResourcesConfig;
import com.example.circulatinglibrary.security.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.stream.Stream;


@Configuration
@EnableWebSecurity
@EnableWebMvc

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private  final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final String [] API_AUTH ={"/api/login/**","/api/register/**"};
    private final String [] API_FREE ={"/api/guest/**"};


    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
    private String [] permit_all(){
        return Stream.of(ResourcesConfig.map, API_AUTH, API_FREE)
                .flatMap(Arrays::stream).toArray(String[]::new);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(permit_all()).permitAll().antMatchers("/api/home/**")
        .authenticated().antMatchers("/api/admin/**").hasRole("ADMIN")
        .antMatchers("/api/home").hasRole("USER")
        .antMatchers("/api/index").hasAnyRole("USER","ADMIN")
        .anyRequest().authenticated();
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }
}
