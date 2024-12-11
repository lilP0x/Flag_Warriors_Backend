package edu.eci.arsw.project.flagwarriors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.project.flagwarriors.model.AuthResponse;
import edu.eci.arsw.project.flagwarriors.model.Player;
import edu.eci.arsw.project.flagwarriors.model.TokenRequest;
import edu.eci.arsw.project.flagwarriors.repository.PlayerRepository;
import edu.eci.arsw.project.flagwarriors.security.JwtTokenProvider;

@Service
public class AuthService {
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private PlayerRepository playerRepository;

    public AuthResponse authenticateMicrosoftToken(String msToken) {
        try {
            // 1. Validar el token de Microsoft
            // Por ahora, asumimos que el token es válido
            
            // 2. Extraer información del jugador del token
            // Por ahora usamos datos de ejemplo
            String email = "email@ejemplo.com"; // Esto debería venir del token
            String name = "Nuevo Jugador";      // Esto debería venir del token
            
            // 3. Buscar o crear jugador
            Player player = playerRepository.findByEmail(email)
                .orElse(Player.builder()
                    .name(name)
                    .email(email)
                    .score(0)
                    .flag(false)
                    .build());
            
            player = playerRepository.save(player);
            
            // 4. Generar JWT
            String jwt = jwtTokenProvider.generateToken(player.getId().toString());
            
            return AuthResponse.builder()
                    .token(jwt)
                    .type("Bearer")
                    .username(player.getName())
                    .userId(player.getId())
                    .message("Login successful")
                    .build();
                    
        } catch (Exception e) {
            throw new RuntimeException("Error en la autenticación: " + e.getMessage());
        }
    }
}