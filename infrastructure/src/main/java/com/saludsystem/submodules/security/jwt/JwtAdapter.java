package com.saludsystem.submodules.security.jwt;

import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@Component
public class JwtAdapter implements JwtPort {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private int expiration;

	@Value("${jwt.refresh.expiration}")
	private int refreshExpiration;

	private SecretKey getKey() {
		return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
	}

	@Override
	public String generateAccessToken(UserDetails user) {
		return Jwts.builder().setSubject(user.getUsername()) // 👈 usar username (puede ser email si tu UserDetails lo
																// maneja así)
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
	}

	@Override
	public String generateRefreshToken(UserDetails user) {
		return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + refreshExpiration * 1000L))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
	}

	@Override
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			log.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			log.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			log.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}

	@Override
	public String extractUsername(String token) {
		return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody().getSubject();
	}

	@Override
	public long getAccessTokenExpiration() {
		return expiration;
	}
}
