package com.example.circulatinglibrary.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.stream.IntStream;

@Configuration
@EnableWebMvc
public class ResourcesConfig implements WebMvcConfigurer {
    public static  final String [] map =
            {
                    "/css/**",
                    "/js/**",
                    "/img/**",
                    "/html/**"
            };
    private final  String [] loc =
            {
                    "classpath:/static/css/",
                    "classpath:/static/js/",
                    "classpath:/static/img/",
                    "classpath:/static/html/"
            };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(
                map.length!=loc.length
        )
            IntStream.range(0,map.length)
            .forEach(idx->registry.addResourceHandler(map[idx]).addResourceLocations(loc[idx]));
    }
}
