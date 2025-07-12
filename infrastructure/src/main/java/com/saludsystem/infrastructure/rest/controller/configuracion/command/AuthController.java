package com.saludsystem.infrastructure.rest.controller.configuracion.command;

import com.configuracion.application.dto.post.LoginUserDto;
import com.configuracion.application.dto.post.NewUserDto;
import com.configuracion.application.services.AuthService;
import com.configuracion.application.services.UsuarioService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

  private final AuthService authService;
  private final UsuarioService usuarioService;

  @Autowired
  public AuthController(AuthService authService, UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
    this.authService = authService;
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, Object>> login
          (@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(
          Map.of("message", "Check your credentials!!"));
    }
    try {
      Map<String, Object> tokens = authService.authenticate(
                      loginUserDto.getEmail(), loginUserDto.getPassword());
      return ResponseEntity.ok(tokens);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(
          Map.of("message", "Check your credentials!!"));
    }
  }

  @PostMapping("/register")
  public ResponseEntity<Map<String, Object>> register(
          @Valid @RequestBody NewUserDto newUserDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(
          Map.of("message", "Check the fields!!"));
    }
    try {
      usuarioService.saveUsuario(newUserDto);
      Map<String, Object> response = new HashMap<>();
      response.put("message", "User registered successfully");
      response.put("username", newUserDto.getEmail());
      response.put("role", newUserDto.getRoleId());

      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(
          Map.of("message", e.getMessage()));
    }
  }

  @PostMapping("/refresh-token")
  public ResponseEntity<Map<String, Object>> refreshToken(@RequestBody Map<String, String> requestBody) {
    try {
      String refreshToken = requestBody.get("refreshToken");
      if (refreshToken == null || refreshToken.isBlank()) {
        return ResponseEntity.badRequest()
                .body(Map.of("error", "Refresh token is required", "code", "RT001"));
      }
      Map<String, Object> tokens = authService.refreshToken(refreshToken);
      return ResponseEntity.ok(tokens);
    } catch (AuthService.TokenInvalidatedException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
              .body(Map.of("error", e.getMessage(), "code", "RT002"));
    } catch (AuthService.TokenExpiredException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
              .body(Map.of("error", e.getMessage(), "code", "RT003"));
    } catch (AuthService.InvalidTokenException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
              .body(Map.of("error", e.getMessage(), "code", "RT004"));
    } catch (AuthService.UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body(Map.of("error", e.getMessage(), "code", "RT005"));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body(Map.of("error", "Internal server error", "code", "RT500"));
    }
  }

  @GetMapping("/check-auth")
  public ResponseEntity<Map<String, Object>> checkAuth() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || !authentication.isAuthenticated() ||
        authentication.getPrincipal().equals("anonymousUser")) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body(Map.of("authenticated", false, "message",
                       "User is not authenticated"));
    }
    Map<String, Object> response = new HashMap<>();
    response.put("authenticated", true);
    response.put("message", "User is authenticated");
    response.put("username", authentication.getName());
    return ResponseEntity.ok(response);
  }

  @PostMapping("/logout")
  public ResponseEntity<Map<String, String>> logout(@RequestHeader("Authorization") String token) {
    if (token == null || !token.startsWith("Bearer ")) {
      return ResponseEntity.badRequest().body(Map.of("message", "Invalid token format"));
    }
    String jwt = token.substring(7);
    authService.invalidateToken(jwt);
    return ResponseEntity.ok(Map.of("message", "Logged out successfully"));
  }
}