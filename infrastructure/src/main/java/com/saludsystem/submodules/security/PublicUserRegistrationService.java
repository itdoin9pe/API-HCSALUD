package com.saludsystem.submodules.security;

import com.saludsystem.submodules.configuracion.model.dtos.auth.NewUserDto;
import com.saludsystem.submodules.core.configuracion.adapter.entity.RoleEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.RoleJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.SysSaludJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.UserJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PublicUserRegistrationService {
    @Autowired
    private UserJpaRepository usuarioRepository;

    @Autowired
    private SysSaludJpaRepository hospitalRepository;

    @Autowired
    private RoleJpaRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserEntity registrarUsuarioPublico(NewUserDto request) {
        // Validar que el hospital existe
        SysSaludEntity hospital = hospitalRepository.findById(request.getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado con ID: " + request.getHospitalId()));

        // Validar que el rol existe
        RoleEntity role = roleRepository.findById(request.getRoleId()).orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + request.getRoleId()));

        // Crear usuario
        UserEntity usuario = new UserEntity();
        usuario.setFirstName(request.getFirstName());
        usuario.setLastName(request.getLastName());
        usuario.setEmail(request.getEmail());
        usuario.setUsername(request.getUsername());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setPhoneNumber(request.getPhoneNumber());
        usuario.setAddress(request.getAddress());
        usuario.setDocumentType(request.getDocumentType());
        usuario.setDocumentNumber(request.getDocumentNumber());
        usuario.setPhoto(request.getPhoto());
        usuario.setRol(role);
        usuario.setHospital(hospital);
        usuario.setEstado(request.getEstado());

        return usuarioRepository.save(usuario);
    }
}
