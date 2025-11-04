package com.saludsystem.submodules.security;

import com.saludsystem.submodules.security.jwt.CustomerUserDetails;
import com.saludsystem.submodules.security.jwt.JwtPort;
import com.saludsystem.submodules.configuracion.model.dtos.auth.LoginRequestDto;
import com.saludsystem.submodules.configuracion.port.out.JwtLoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final JwtPort jwtPort;
	private final UserDetailsService userDetailsService;

	/**
	 * @param authenticationManager
	 * @param jwtPort
	 * @param userDetailsService
	 */
	public AuthService(AuthenticationManager authenticationManager, JwtPort jwtPort,
			UserDetailsService userDetailsService) {
		this.authenticationManager = authenticationManager;
		this.jwtPort = jwtPort;
		this.userDetailsService = userDetailsService;
	}

	public JwtLoginResponse authenticateUser(LoginRequestDto loginRequest) {
		// 1️⃣ autenticar credenciales
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		// 2️⃣ obtener usuario autenticado
		CustomerUserDetails userDetails = (CustomerUserDetails) authentication.getPrincipal();

		// 3️⃣ generar tokens usando el adapter a través del puerto
		String accessToken = jwtPort.generateAccessToken(userDetails);
		String refreshToken = jwtPort.generateRefreshToken(userDetails);
		long expiresIn = jwtPort.getAccessTokenExpiration();

		// 4️⃣ devolver response
		return new JwtLoginResponse(accessToken, refreshToken, expiresIn);
	}
	
    public JwtLoginResponse refreshToken(String refreshToken) {
        if (!jwtPort.validateToken(refreshToken)) {
            throw new RuntimeException("Invalid or expired refresh token");
        }
        String username = jwtPort.extractUsername(refreshToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String newAccessToken = jwtPort.generateAccessToken(userDetails);
        String newRefreshToken = jwtPort.generateRefreshToken(userDetails); // opcional regenerar
        long expiresIn = jwtPort.getAccessTokenExpiration();
        return new JwtLoginResponse(newAccessToken, newRefreshToken, expiresIn);
    }
}