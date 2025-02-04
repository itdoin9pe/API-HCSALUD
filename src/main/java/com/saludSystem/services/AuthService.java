package com.saludSystem.services;

import com.saludSystem.dtos.NewUserDto;
import com.saludSystem.entities.Doctor;
import com.saludSystem.entities.Role;
import com.saludSystem.entities.User;
import com.saludSystem.enums.UserRole;
import com.saludSystem.jwt.JwtUtil;
import com.saludSystem.repositories.RoleRepository;
import com.saludSystem.repositories.modules.Doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final DoctorRepository doctorRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    public AuthService(UserService userService, RoleRepository roleRepository, DoctorRepository doctorRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public String authenticate(String username, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication  authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }

    public void registerUser(NewUserDto newUserDto){
        if (userService.existsByUsername(newUserDto.getUsername())){
            throw new IllegalArgumentException("Username already exists!!");
        }

        Role roleUser = roleRepository.findByName(UserRole.USER).orElseThrow(()->new RuntimeException("Role not found"));
        // Si doctorId no es nulo, buscamos al doctor
        Doctor doctor = null;
        if (newUserDto.getDoctorId() != null) {
            doctor = doctorRepository.findById(newUserDto.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
        }

        User user = new User(
                newUserDto.getLastName(),
                newUserDto.getFirstName(),
                newUserDto.getPhoneNumber(),
                newUserDto.getAddress(),
                newUserDto.getEmail(),
                newUserDto.getDocumentType(),
                newUserDto.getDocumentNumber(),
                newUserDto.getPhoto(),
                newUserDto.getUsername(),
                passwordEncoder.encode(newUserDto.getPassword()),
                roleUser, doctor);
        userService.save(user);
    }

    public UserRole getAuthenticatedUserRole(String username) {
        User user = userService.findEntityByUsername(username);
        return user.getRole().getName();
    }

}
