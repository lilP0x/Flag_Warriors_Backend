package edu.eci.arsw.project.flagwarriors.controllers;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("Configurando CORS...");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .allowCredentials(false);
        System.out.println("CORS configurado con éxito");
    }




// @Configuration
// public class WebConfig implements WebMvcConfigurer {
//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("https://proyectoflagwarriors-dzbpcyeccmfzgaad.northeurope-01.azurewebsites.net","http://localhost:3000") // Asegúrate de que el frontend esté en este puerto
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("*");
//     }

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    //     registry.addMapping("/**")
    //         .allowedOrigins("http://localhost:3000") // Asegúrate de que el frontend esté en este puerto
    //         .allowedMethods("GET", "POST", "PUT", "DELETE")
    //         .allowedHeaders("*");
    // }
    
}

