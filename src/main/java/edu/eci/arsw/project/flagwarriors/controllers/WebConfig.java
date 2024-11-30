package edu.eci.arsw.project.flagwarriors.controllers;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //@Override
    //public void addCorsMappings(CorsRegistry registry) {
    //    registry.addMapping("/**")
    //            .allowedOrigins("http://proyectoflagwarriors-dzbpcyeccmfzgaad.northeurope-01.azurewebsites.net") // Asegúrate de que el frontend esté en este puerto
    //            .allowedMethods("GET", "POST", "PUT", "DELETE")
    //            .allowedHeaders("*");
    //}

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // Asegúrate de que el frontend esté en este puerto
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*");
    }
}
