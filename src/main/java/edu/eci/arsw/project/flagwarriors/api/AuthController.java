package edu.eci.arsw.project.flagwarriors.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.project.flagwarriors.model.AuthResponse;
import edu.eci.arsw.project.flagwarriors.model.TokenRequest;
import edu.eci.arsw.project.flagwarriors.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/microsoft")
public ResponseEntity<AuthResponse> authenticateWithMicrosoft(@RequestBody TokenRequest tokenRequest) {
    try {
        System.out.println("Recibido token request: " + tokenRequest);
        if (tokenRequest.getMsToken() == null || tokenRequest.getName() == null) {
            return ResponseEntity.badRequest()
                .body(AuthResponse.builder()
                    .message("Token de Microsoft y nombre son requeridos")
                    .build());
        }
        
        AuthResponse response = authService.authenticateMicrosoftToken(tokenRequest.getMsToken());
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        System.out.println("Error en autenticación: " + e.getMessage());
        return ResponseEntity.badRequest()
            .body(AuthResponse.builder()
                .message("Error en la autenticación: " + e.getMessage())
                .build());
    }
}
}