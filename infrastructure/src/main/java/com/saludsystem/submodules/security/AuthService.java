package com.saludsystem.submodules.security;

import com.saludsystem.submodules.security.jwt.CustomerUserDetails;
import com.saludsystem.submodules.configuracion.dtos.LoginRequestDto;
import com.saludsystem.submodules.configuracion.model.dto.command.JwtLoginResponse;
import com.saludsystem.submodules.security.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtils;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public JwtLoginResponse authenticateUser(LoginRequestDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()));

        //SecurityContextHolder.getContext().setAuthentication(authentication);

        CustomerUserDetails userDetails = (CustomerUserDetails) authentication.getPrincipal();

        String accessToken = jwtUtils.generateToken(authentication);
        String refreshToken = jwtUtils.generateRefreshToken(userDetails);
        long expiresIn = jwtUtils.getAccessTokenExpirationInSeconds();

        //return new JwtResponse(jwt, loginRequest.getEmail(), roles);
        return new JwtLoginResponse(accessToken, refreshToken, expiresIn);
    }
}