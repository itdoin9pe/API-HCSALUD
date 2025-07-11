package com.saludsystem.domain.configuracion.port.in.service;

import com.configuracion.domain.model.UserEntity;
import com.shared.domain.exception.AuthenticationFailedException;
import com.shared.domain.exception.InvalidCredentialsException;
import com.shared.infrastructure.security.jwt.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static com.shared.infrastructure.constants.ErrorMessage.*;

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

    public Map<String, Object> authenticate(String email, String password) {
        try {
            AuthenticationManager authenticationManager = authenticationManagerBuilder.getObject();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
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
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException(INVALID_CREDENTIALS);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationFailedException(FAILED_AUTHENTICATION + e.getMessage());
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