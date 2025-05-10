package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Configuracion.RolePrefixResolver;
import com.saludSystem.application.services.Mantenimiento.EnfermedadService;
import com.saludSystem.domain.model.Configuracion.RoleEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.application.services.Configuracion.AuthService;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarEnfermedadDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearEnfermedadDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.EnfermedadDTO;
import com.saludSystem.domain.model.Mantenimiento.EnfermedadEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.EnfermedadRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {

    private final EnfermedadRepository enfermedadRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final RolePrefixResolver rolePrefixResolver;
    private final AuthService authService;
    private final ModelMapper modelMapper;

    public EnfermedadServiceImpl(EnfermedadRepository enfermedadRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, RolePrefixResolver rolePrefixResolver, AuthService authService, ModelMapper modelMapper) {
        this.enfermedadRepository = enfermedadRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.rolePrefixResolver = rolePrefixResolver;
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveEnfermedad(CrearEnfermedadDTO crearEnfermedadDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        EnfermedadEntity diagnosticoEntity = new EnfermedadEntity();
        diagnosticoEntity.setEnfermedadId(crearEnfermedadDTO.getEnfermedadId());
        diagnosticoEntity.setDescripcion(crearEnfermedadDTO.getDescripcion());
        diagnosticoEntity.setEstado(crearEnfermedadDTO.getEstado());
        diagnosticoEntity.setUser(userEntity);
        diagnosticoEntity.setHospital(hospital);
        enfermedadRepository.save(diagnosticoEntity);
        return new ApiResponse(true, "Diagnostico registrado correctamente");
    }

    @Override
    public List<EnfermedadDTO> getEnfermedadList() {
        return enfermedadRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<EnfermedadDTO> getAllEnfermedad(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EnfermedadEntity> diagnosticoModelPage = enfermedadRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EnfermedadDTO> data = diagnosticoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, diagnosticoModelPage.getTotalElements(), diagnosticoModelPage.getTotalPages(), diagnosticoModelPage.getNumber() +1 );
    }

    @Override
    public ApiResponse updateEnfermedad(String enfermedadId, ActualizarEnfermedadDTO actualizarEnfermedadDTO) {
        EnfermedadEntity diagnosticoEntity = enfermedadRepository.findById(enfermedadId).orElseThrow( () -> new ResourceNotFoundException("Diagnostico no encontrado"));
        Optional.ofNullable(actualizarEnfermedadDTO.getEnfermedadId()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoEntity::setEnfermedadId);
        Optional.ofNullable(actualizarEnfermedadDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoEntity::setDescripcion);
        Optional.ofNullable(actualizarEnfermedadDTO.getEstado()).ifPresent(diagnosticoEntity::setEstado);
        enfermedadRepository.save(diagnosticoEntity);
        return new ApiResponse(true, "Diagnostico registrado correctamente");
    }

    @Override
    public EnfermedadDTO getEnfermedadById(String enfermedadId) {
        EnfermedadEntity enfermedadEntity = enfermedadRepository.findById(enfermedadId).orElseThrow( () -> new ResourceNotFoundException("Diagnostico no encontrado"));
        return convertToDTO(enfermedadEntity);
    }

    @Override
    public ApiResponse deleteEnfermedad(String enfermedadId) {
        enfermedadRepository.deleteById(enfermedadId);
        return new ApiResponse(true, "Diagnostico eliminado correctamente");
    }

    // Impl filtrado por rol de especialidad
    @Override
    public List<EnfermedadDTO> getEnfermedadFiltradosPorRol() {
        UserEntity usuario = authService.getCurrentUser();
        RoleEntity rol = usuario.getRol();
        String prefix = rolePrefixResolver.resolvePrefixFromRole(rol);
        if (prefix == null) {
            return List.of();
        }
        List<EnfermedadEntity> enfernedades = enfermedadRepository.findByRolePrefixAndHospital(
                prefix + "-",
                usuario.getHospital().getHospitalId()
        );
        return enfernedades.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EnfermedadDTO convertToDTO(EnfermedadEntity diagnosticoEntity) {
        return modelMapper.map(diagnosticoEntity, EnfermedadDTO.class);
    }

}