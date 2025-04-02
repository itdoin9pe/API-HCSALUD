package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Configuracion.RolePrefixResolver;
import com.saludSystem.application.services.Mantenimiento.DiagnosticoService;
import com.saludSystem.domain.model.Configuracion.RoleEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.application.services.Configuracion.AuthService;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarDiagnosticoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearDiagnosticoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.DiagnosticoDTO;
import com.saludSystem.domain.model.Mantenimiento.DiagnosticoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.DiagnosticoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.PacienteRepository;
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
public class DiagnosticoServiceImpl implements DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final PacienteRepository pacienteRepository;
    private final RolePrefixResolver rolePrefixResolver;
    private final AuthService authService;
    private final ModelMapper modelMapper;

    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, PacienteRepository pacienteRepository, RolePrefixResolver rolePrefixResolver, AuthService authService, ModelMapper modelMapper) {
        this.diagnosticoRepository = diagnosticoRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.pacienteRepository = pacienteRepository;
        this.rolePrefixResolver = rolePrefixResolver;
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveDiagnostico(CrearDiagnosticoDTO crearDiagnosticoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        DiagnosticoEntity diagnosticoEntity = new DiagnosticoEntity();
        //Optional<PacienteModel> pacienteModel = pacienteRepository.findById(crearDiagnosticoDTO.getPacienteId());
        //pacienteModel.ifPresent(diagnosticoModel::setPacienteId);
        diagnosticoEntity.setEnfermedadId(crearDiagnosticoDTO.getEnfermedadId());
        diagnosticoEntity.setNombreEnfermedad(crearDiagnosticoDTO.getNombreEnfermedad());
        diagnosticoEntity.setEstado(crearDiagnosticoDTO.getEstado());
        diagnosticoEntity.setUser(userEntity);
        diagnosticoEntity.setHospital(hospital);
        diagnosticoRepository.save(diagnosticoEntity);
        return new ApiResponse(true, "Diagnostico registrado correctamente");
    }

    @Override
    public List<DiagnosticoDTO> getDiagnosticoList() {
        return diagnosticoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<DiagnosticoDTO> getAllDiagnostico(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<DiagnosticoEntity> diagnosticoModelPage = diagnosticoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<DiagnosticoDTO> data = diagnosticoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, diagnosticoModelPage.getTotalElements(), diagnosticoModelPage.getTotalPages(), diagnosticoModelPage.getNumber() +1 );
    }

    @Override
    public ApiResponse updateDiagnostico(UUID diagnosticoId, ActualizarDiagnosticoDTO actualizarDiagnosticoDTO) {
        DiagnosticoEntity diagnosticoEntity = diagnosticoRepository.findById(diagnosticoId).orElseThrow( () -> new ResourceNotFoundException("Diagnostico no encontrado"));
        //Optional.ofNullable(actualizarDiagnosticoDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(diagnosticoModel::setPacienteId);
        Optional.ofNullable(actualizarDiagnosticoDTO.getEnfermedadId()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoEntity::setEnfermedadId);
        Optional.ofNullable(actualizarDiagnosticoDTO.getNombreEnfermedad()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoEntity::setNombreEnfermedad);
        Optional.ofNullable(actualizarDiagnosticoDTO.getEstado()).ifPresent(diagnosticoEntity::setEstado);
        diagnosticoRepository.save(diagnosticoEntity);
        return new ApiResponse(true, "Diagnostico registrado correctamente");
    }

    @Override
    public DiagnosticoDTO getDiagnosticoById(UUID diagnosticoId) {
        DiagnosticoEntity diagnosticoEntity = diagnosticoRepository.findById(diagnosticoId).orElseThrow( () -> new ResourceNotFoundException("Diagnostico no encontrado"));
        return convertToDTO(diagnosticoEntity);
    }

    @Override
    public ApiResponse deleteDiagnostico(UUID diagnosticoId) {
        diagnosticoRepository.deleteById(diagnosticoId);
        return new ApiResponse(true, "Diagnostico eliminado correctamente");
    }

    @Override
    public List<DiagnosticoDTO> getDiagnosticosFiltradosPorRol() {
        UserEntity usuario = authService.getCurrentUser();
        RoleEntity rol = usuario.getRol();
        String prefix = rolePrefixResolver.resolvePrefixFromRole(rol);
        if (prefix == null) {
            return List.of();
        }
        List<DiagnosticoEntity> diagnosticos = diagnosticoRepository.findByRolePrefixAndHospital(
                prefix + "-",
                usuario.getHospital().getHospitalId()
        );
        return diagnosticos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DiagnosticoDTO convertToDTO(DiagnosticoEntity diagnosticoEntity) {
        return modelMapper.map(diagnosticoEntity, DiagnosticoDTO.class);
    }

}