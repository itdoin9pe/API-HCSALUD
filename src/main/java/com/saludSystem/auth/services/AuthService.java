package com.saludSystem.auth.services;

import com.saludSystem.auth.dtos.NewUserDto;
import com.saludSystem.auth.entities.Role;
import com.saludSystem.auth.entities.User;
import com.saludSystem.auth.enums.UserRole;
import com.saludSystem.auth.jwt.JwtUtil;
import com.saludSystem.auth.repositories.RoleRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.RoleList;

public class AuthService {

    private final UserService userService;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtill;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthService(UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtill, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtill = jwtUtill;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public String authenticate(String username, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication  authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtill.generateToken(authResult);
    }

    public void registerUser(NewUserDto newUserDto){
        if (userService.existsByUsername(newUserDto.getUsername())){
            throw new IllegalArgumentException("Username already exists!!");
        }

        Role roleUser = roleRepository.findByName(UserRole.USER).orElseThrow(()->new RuntimeException("Role not found"));
        User user = new User(newUserDto.getUsername(), passwordEncoder.encode(newUserDto.getPassword()),roleUser);
        userService.save(user);
    }
}
