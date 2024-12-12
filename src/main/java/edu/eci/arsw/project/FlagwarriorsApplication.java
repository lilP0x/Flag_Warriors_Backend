package edu.eci.arsw.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.project.flagwarriors"})
public class FlagwarriorsApplication {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private long jwtExpirationMs;

    public static void main(String[] args) {
        SpringApplication.run(FlagwarriorsApplication.class, args);
    }

    public void someMethod() {
        System.out.println("JWT Secret: " + jwtSecret);
        System.out.println("JWT Expiration: " + jwtExpirationMs);
    }
}