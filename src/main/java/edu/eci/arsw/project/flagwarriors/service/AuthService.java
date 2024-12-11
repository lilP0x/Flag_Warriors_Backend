package edu.eci.arsw.project.flagwarriors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.project.flagwarriors.model.AuthResponse;
import edu.eci.arsw.project.flagwarriors.model.Player;
import edu.eci.arsw.project.flagwarriors.repository.PlayerRepository;
import edu.eci.arsw.project.flagwarriors.security.JwtTokenProvider;


    

@Service
public class AuthService {
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private PlayerRepository playerRepository;

    public AuthResponse authenticateMicrosoftPlayer(String msToken) {
        // 1. Validar el token de Microsoft
        // 2. Extraer información del jugador
        // 3. Crear o actualizar jugador en la base de datos
        
        // Ejemplo de creación/actualización de jugador
        Player player = playerRepository.findByEmail("email@ejemplo.com")
            .orElse(Player.builder()
                .name("Nuevo Jugador")
                .email("email@ejemplo.com")
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
    }
}
