package com.saludsystem.submodules.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtPort {
    String generateAccessToken(UserDetails user);
    String generateRefreshToken(UserDetails user);
    boolean validateToken(String token, UserDetails user);
    String extractUsername(String token);
    long getAccessTokenExpiration();
}
