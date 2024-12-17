package com.saludSystem.jwt;

import com.saludSystem.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@NoArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserService userService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*
    	final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);*/
        
    	
    	    final String authorizationHeader = request.getHeader("Authorization");

    	    String username = null;
    	    String jwt = null;

    	    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
    	        jwt = authorizationHeader.substring(7);
    	        username = jwtUtil.extractUsername(jwt);
    	        System.out.println("JWT Filter: Token detected, username = " + username);
    	    }

    	    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
    	        UserDetails userDetails = userService.loadUserByUsername(username);

    	        if (jwtUtil.validateToken(jwt, userDetails)){
    	            UsernamePasswordAuthenticationToken authToken =
    	                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    	            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    	            SecurityContextHolder.getContext().setAuthentication(authToken);
    	            System.out.println("JWT Filter: Authentication successful for username = " + username);
    	        } else {
    	            System.out.println("JWT Filter: Token validation failed.");
    	        }
    	    }

    	    filterChain.doFilter(request, response);
    }
}
