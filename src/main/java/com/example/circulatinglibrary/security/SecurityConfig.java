package com.example.circulatinglibrary.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
@EnableWebMvc

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login");
        http
                .csrf()
                .disable()
                .authorizeRequests()
              .antMatchers("/","/index").permitAll()
               // .antMatchers("/books/*").permitAll()
                //.antMatchers("/home").permitAll()
               // .antMatchers("/profile").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home",true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .httpBasic();
    }
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser = User.builder()
                .username("AnnaSmith")
                .password(passwordEncoder.encode("anna"))
                .roles("")
                //  .roles(ApplicationUserRole.STUDENT.name()) //ROLE_STUDENT
                //.authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())
                .build();

        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("linda"))
                .roles("")
                //.roles(ApplicationUserRole.ADMIN.name()) //ROLE_ADMIN
                //.authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
                .build();

        UserDetails TomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("tom"))
                .roles("")
                //.roles(ApplicationUserRole.ADMINISTRATEE.name())
                //.authorities(ApplicationUserRole.ADMINISTRATEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                annaSmithUser,
                lindaUser,
                TomUser);

    }


}
