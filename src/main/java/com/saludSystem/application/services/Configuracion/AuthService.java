package com.saludSystem.application.services.Configuracion;

import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.security.jwt.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final Set<String> invalidTokens = ConcurrentHashMap.newKeySet();

    @Autowired
    public AuthService(UserService userService, JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public Map<String, Object> authenticate(String username, String password) {
        try {
            AuthenticationManager authenticationManager = authenticationManagerBuilder.getObject();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtUtil.generateToken(authentication);
            String refreshToken = jwtUtil.generateRefreshToken(userDetails);
            Map<String,Object> tokens = new HashMap<>();
            tokens.put("access_token", jwt);
            tokens.put("refresh_token", refreshToken);
            tokens.put("expires_in", jwtUtil.getAccessTokenExpirationInSeconds());
            return tokens;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }

    public Map<String, Object> refreshToken(String refreshToken) {
        try {
            // 1. Verificar si el token está invalidado
            if (isTokenInvalid(refreshToken)) {
                throw new TokenInvalidatedException("Refresh token has been invalidated");
            }

            // 2. Extraer username y validar
            String username = jwtUtil.extractUsername(refreshToken);
            if (username == null) {
                throw new InvalidTokenException("Invalid refresh token: no username");
            }

            // 3. Cargar UserDetails
            UserDetails userDetails = userService.loadUserByUsername(username);

            // 4. Validar token
            if (!jwtUtil.validateToken(refreshToken, userDetails)) {
                throw new InvalidTokenException("Invalid refresh token: validation failed");
            }

            // 5. Invalidar el refresh token anterior (rotación)
            invalidateToken(refreshToken);

            // 6. Generar nuevos tokens
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            String newAccessToken = jwtUtil.generateToken(authentication);
            String newRefreshToken = jwtUtil.generateRefreshToken(userDetails);

            // 7. Retornar nuevos tokens
            Map<String, Object> tokens = new HashMap<>();
            tokens.put("access_token", newAccessToken);
            tokens.put("refresh_token", newRefreshToken);
            tokens.put("expires_in", jwtUtil.getAccessTokenExpirationInSeconds());

            return tokens;

        } catch (ExpiredJwtException ex) {
            throw new TokenExpiredException("Refresh token expired");
        } catch (JwtException | IllegalArgumentException ex) {
            throw new InvalidTokenException("Invalid refresh token");
        } catch (UsernameNotFoundException ex) {
            throw new UserNotFoundException("User not found");
        }
    }

    /*
    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2User oAuth2User = ((OAuth2AuthenticationToken) authentication).getPrincipal();
            String email = (String) oAuth2User.getAttributes().get("email");
            return userService.findEntityByEmail(email);
        } else {
            // Tu lógica existente para JWT
            String email = authentication.getName();
            return userService.findEntityByEmail(email);
        }
    }*/

    public UserEntity getCurrentUser() {
        // Obtiene el Authentication del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("Email no autenticado");
        }

        // Obtiene el username/email del principal (que en tu caso es el email)
        String email = authentication.getName();

        // Busca el usuario en la BD usando tu UserService
        return userService.findEntityByEmail(email);
    }

    public void invalidateToken(String token) {
        invalidTokens.add(token);
    }

    public boolean isTokenInvalid(String token) {
        return invalidTokens.contains(token);
    }

    public class TokenInvalidatedException extends RuntimeException {
        public TokenInvalidatedException(String message) {
            super(message);
        }
    }

    public class InvalidTokenException extends RuntimeException {
        public InvalidTokenException(String message) {
            super(message);
        }
    }

    public class TokenExpiredException extends RuntimeException {
        public TokenExpiredException(String message) {
            super(message);
        }
    }

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

}