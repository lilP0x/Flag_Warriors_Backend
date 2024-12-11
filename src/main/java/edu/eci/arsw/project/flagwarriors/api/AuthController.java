package edu.eci.arsw.project.flagwarriors.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.project.flagwarriors.model.AuthResponse;

@RestController
public class AuthController {
    @PostMapping("/api/auth")
    public ResponseEntity<AuthResponse> authenticateWithMicrosoft(@RequestBody String msToken) {
            return null;
    }
}
