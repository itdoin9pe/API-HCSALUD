package com.saludsystem.submodules.rest.controller.configuracion.command;

import com.saludsystem.submodules.configuracion.dtos.LoginRequestDto;
import com.saludsystem.submodules.configuracion.model.dto.JwtResponse;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.security.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Auth")
@RestController
@RequestMapping("/api")
public class AuthController {

  private final AuthService authService;
  private final AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {
      Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(), // Usar email como identificador
                    loginRequest.getPassword()
            )
    );
    return ResponseEntity.ok(authService.authenticateUser(loginRequest));
  }
}