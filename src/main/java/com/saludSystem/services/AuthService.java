package com.saludSystem.services;

import com.saludSystem.dtos.NewUserDto;
//import com.saludSystem.entities.Doctor;
import com.saludSystem.entities.Role;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.enums.UserRole;
import com.saludSystem.jwt.JwtUtil;
import com.saludSystem.repositories.RoleRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final SysSaludRepository sysSaludRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final Set<String> invalidTokens = ConcurrentHashMap.newKeySet(); // Lista negra en memoria

    @Autowired
    public AuthService(UserService userService, RoleRepository roleRepository, SysSaludRepository sysSaludRepository,PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public Map<String, String> authenticate(String username, String password) {
        try {
            AuthenticationManager authenticationManager = authenticationManagerBuilder.getObject();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtUtil.generateToken(authentication);
            String refreshToken = jwtUtil.generateRefreshToken(userDetails);
            Map<String, String> tokens = new HashMap<>();
            tokens.put("access_token", jwt);
            tokens.put("refresh_token", refreshToken);

            return tokens;
        } catch (Exception e) {
            e.printStackTrace(); // Agrega esto para ver la excepción en los logs
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }

    /*
    public void registerUser(NewUserDto newUserDto){
        if (userService.existsByEmail(newUserDto.getEmail())){
            throw new IllegalArgumentException("Username already exists!!");
        }

        Role roleUser = roleRepository.findByName(UserRole.ADMIN)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        SysSalud hospital = sysSaludRepository.findById(newUserDto.getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        User user = User.builder()
                .lastName(newUserDto.getLastName())
                .firstName(newUserDto.getFirstName())
                .phoneNumber(newUserDto.getPhoneNumber())
                .address(newUserDto.getAddress())
                .email(newUserDto.getEmail())
                .documentType(newUserDto.getDocumentType())
                .documentNumber(newUserDto.getDocumentNumber())
                .photo(newUserDto.getPhoto().getBytes())
                .username(newUserDto.getUsername())
                .password(passwordEncoder.encode(newUserDto.getPassword()))
                .rol(roleUser)
                .hospital(hospital)
                .build();

        userService.save(user);
    }


     */
    public Map<String, String> refreshToken(String refreshToken) {
        try {
            String username = jwtUtil.extractUsername(refreshToken);
            UserDetails userDetails = userService.loadUserByUsername(username);

            if (jwtUtil.validateToken(refreshToken, userDetails)) {
                String newAccessToken = jwtUtil.generateToken(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
                String newRefreshToken = jwtUtil.generateRefreshToken(userDetails);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", newAccessToken);
                tokens.put("refresh_token", newRefreshToken);

                return tokens;
            } else {
                throw new RuntimeException("Invalid refresh token");
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not refresh token: " + e.getMessage());
        }
    }


    public void invalidateToken(String token) {
        invalidTokens.add(token);
    }

    public boolean isTokenInvalid(String token) {
        return invalidTokens.contains(token);
    }

}