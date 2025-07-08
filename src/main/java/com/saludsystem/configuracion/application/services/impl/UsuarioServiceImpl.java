package com.saludsystem.configuracion.application.services.impl;

import com.saludsystem.configuracion.application.dto.res.UsuarioResponse;
import com.saludsystem.configuracion.application.dto.req.NewUserDto;
import com.saludsystem.configuracion.application.dto.res.ActualizarUsuarioDTO;
import com.saludsystem.configuracion.application.services.UsuarioService;
import com.saludsystem.configuracion.domain.model.RoleEntity;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.RoleRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UserRepository userRepository, RoleRepository roleRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ListResponse<UsuarioResponse> getAllUsuario(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<UserEntity> userPage = userRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<UsuarioResponse> data = userPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, userPage.getTotalElements(), userPage.getTotalPages(), userPage.getNumber() + 1);
    }

    @Override
    public UserEntity saveUsuario(NewUserDto newUserDto) {
        RoleEntity role = roleRepository.findByRoleId(newUserDto.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findAll()
                .stream().findFirst().orElseThrow( () -> new RuntimeException("Hospital no encontrado"));
        UserEntity user = UserEntity.builder()
                .lastName(newUserDto.getLastName())
                .firstName(newUserDto.getFirstName())
                .phoneNumber(newUserDto.getPhoneNumber())
                .address(newUserDto.getAddress())
                .email(newUserDto.getEmail())
                .documentType(newUserDto.getDocumentType())
                .documentNumber(newUserDto.getDocumentNumber())
                .photo(newUserDto.getPhoto())
                .username(newUserDto.getUsername())
                .password(passwordEncoder.encode(newUserDto.getPassword())) // Hash the password in real case
                .estado(newUserDto.getEstado())
                .rol(role)
                .hospital(hospital)
                .build();
        return userRepository.save(user);
    }

    @Override
    public ActualizarUsuarioDTO updateUsuario(UUID userId, ActualizarUsuarioDTO actualizarUsuarioDTO) {
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("Usuario no encontrado" + userId));
        Optional.ofNullable(actualizarUsuarioDTO.getLastName()).filter(desc -> !desc.isBlank()).ifPresent(user::setLastName);
        Optional.ofNullable(actualizarUsuarioDTO.getFirstName()).filter(desc -> !desc.isBlank()).ifPresent(user::setFirstName);
        Optional.ofNullable(actualizarUsuarioDTO.getPhoneNumber()).filter(desc -> !desc.isBlank()).ifPresent(user::setPhoneNumber);
        Optional.ofNullable(actualizarUsuarioDTO.getAddress()).filter(desc -> !desc.isBlank()).ifPresent(user::setAddress);
        Optional.ofNullable(actualizarUsuarioDTO.getEmail()).filter(desc -> !desc.isBlank()).ifPresent(user::setEmail);
        Optional.ofNullable(actualizarUsuarioDTO.getDocumentType()).filter(desc -> !desc.isBlank()).ifPresent(user::setDocumentType);
        Optional.ofNullable(actualizarUsuarioDTO.getDocumentNumber()).filter(desc -> !desc.isBlank()).ifPresent(user::setDocumentNumber);
        Optional.ofNullable(actualizarUsuarioDTO.getUsername()).filter(desc -> !desc.isBlank()).ifPresent(user::setUsername);
        Optional.ofNullable(actualizarUsuarioDTO.getPassword()).filter(desc -> !desc.isBlank()).ifPresent(user::setPassword);
        if (actualizarUsuarioDTO.getPassword() != null && !actualizarUsuarioDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(actualizarUsuarioDTO.getPassword()));
        }
        Optional.ofNullable(actualizarUsuarioDTO.getEstado()).ifPresent(user::setEstado);
        userRepository.save(user);
        return modelMapper.map(user, ActualizarUsuarioDTO.class);
    }

    @Override
    public ApiResponse deleteUsuario(UUID userId) {
        userRepository.deleteById(userId);
        return new ApiResponse(true, "Usuario eliminado correctamente");
    }

    private UsuarioResponse convertToDTO(UserEntity user) {
        return modelMapper.map(user, UsuarioResponse.class);
    }

}