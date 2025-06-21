package com.saludSystem.application.services.Configuracion.impl;

import com.saludSystem.application.services.Configuracion.UsuarioService;
import com.saludSystem.domain.model.Configuracion.RoleEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.RoleRepository;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.application.dtos.Configuracion.POST.NewUserDto;
import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarUsuarioDTO;
import com.saludSystem.application.dtos.Configuracion.GET.UsuarioDTO;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    //private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UserRepository userRepository, RoleRepository roleRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
        //this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ListResponse<UsuarioDTO> getAllUsuario(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<UserEntity> userPage = userRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<UsuarioDTO> data = userPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, userPage.getTotalElements(), userPage.getTotalPages(), userPage.getNumber() + 1);
    }

    @Override
    public UserEntity saveUsuario(NewUserDto newUserDto) {
        /*
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
                //.password(passwordEncoder.encode(newUserDto.getPassword())) // Hash the password in real case
                .estado(newUserDto.getEstado())
                .rol(role)
                .hospital(hospital)
                .build();

        return userRepository.save(user);*/
        return null;
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
        /*
        if (actualizarUsuarioDTO.getPassword() != null && !actualizarUsuarioDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(actualizarUsuarioDTO.getPassword()));
        }*/
        Optional.ofNullable(actualizarUsuarioDTO.getEstado()).ifPresent(user::setEstado);
        userRepository.save(user);
        return modelMapper.map(user, ActualizarUsuarioDTO.class);
    }

    @Override
    public ApiResponse deleteUsuario(UUID userId) {
        userRepository.deleteById(userId);
        return new ApiResponse(true, "Usuario eliminado correctamente");
    }

    private UsuarioDTO convertToDTO(UserEntity user) {
        return modelMapper.map(user, UsuarioDTO.class);
    }

}