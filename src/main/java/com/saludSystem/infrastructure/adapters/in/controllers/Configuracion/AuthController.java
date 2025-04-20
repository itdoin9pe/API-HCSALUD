package com.saludSystem.infrastructure.adapters.in.controllers.Configuracion;

import com.saludSystem.application.dtos.Configuracion.POST.LoginUserDto;
import com.saludSystem.application.dtos.Configuracion.POST.NewUserDto;
import com.saludSystem.application.services.Configuracion.AuthService;
import com.saludSystem.application.services.Configuracion.UsuarioService;
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
  public AuthController(AuthService authService,
                        UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
    this.authService = authService;
  }

  @GetMapping("/saludo")
  public String saludo() {
    return "Saludos REST";
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login
          (@Valid @RequestBody LoginUserDto loginUserDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(
          Map.of("message", "Check your credentials!!"));
    }

    try {
      Map<String, String> tokens = authService.authenticate(
          loginUserDto.getEmail(), loginUserDto.getPassword());
      return ResponseEntity.ok(tokens);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(
          Map.of("message", "Check your credentials!!"));
    }
  }

  /* Solo en producccion
  @PostMapping("/login")
  public ResponseEntity<Map<String, Object>> login(
          @Valid @RequestBody LoginUserDto loginUserDto,
          BindingResult bindingResult,
          HttpServletResponse response) {

    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(
              Map.of("success", false, "message", "Check your credentials!!"));
    }

    try {
      Map<String, String> tokens = authService.authenticate(
              loginUserDto.getEmail(), loginUserDto.getPassword());

      // Configura la cookie para el token de refresco
      ResponseCookie refreshTokenCookie = ResponseCookie.from("refresh_token", tokens.get("refresh_token"))
              .httpOnly(true)
              .secure(true) // Solo en HTTPS
              .path("/api/refresh-token")
              .maxAge(7 * 24 * 60 * 60) // 7 días
              .sameSite("None") // Para cross-site
              .build();

      response.addHeader(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());

      return ResponseEntity.ok(Map.of(
              "success", true,
              "access_token", tokens.get("access_token"),
              "message", "Login successful"
      ));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(
              Map.of("success", false, "message", "Check your credentials!!"));
    }
  }*/

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
  public ResponseEntity<Map<String, String>>
  refreshToken(@RequestBody Map<String, String> requestBody) {
    try {
      String refreshToken = requestBody.get("refreshToken");
      if (refreshToken == null) {
        return ResponseEntity.badRequest().body(
            Map.of("error", "refreshToken is required"));
      }
      Map<String, String> tokens = authService.refreshToken(refreshToken);
      return ResponseEntity.ok(tokens);
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
    }
  }

  @GetMapping("/check-auth")
  public ResponseEntity<Map<String, Object>> checkAuth() {
    Authentication authentication =
        SecurityContextHolder.getContext().getAuthentication();
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
  public ResponseEntity<Map<String, String>>
  logout(@RequestHeader("Authorization") String token) {
    if (token == null || !token.startsWith("Bearer ")) {
      return ResponseEntity.badRequest().body(
          Map.of("message", "Invalid token format"));
    }
    String jwt = token.substring(7);
    authService.invalidateToken(jwt);
    return ResponseEntity.ok(Map.of("message", "Logged out successfully"));
  }
}
