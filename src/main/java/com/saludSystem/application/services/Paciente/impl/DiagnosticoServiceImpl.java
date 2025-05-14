package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.DiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearDiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarDiagnosticoDTO;
import com.saludSystem.application.services.Paciente.DiagnosticoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Mantenimiento.EnfermedadEntity;
import com.saludSystem.domain.model.Paciente.DiagnosticoEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.EnfermedadRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.DiagnosticoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final EnfermedadRepository enfermedadRepository;
    private final ModelMapper modelMapper;

    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, EnfermedadRepository enfermedadRepository, ModelMapper modelMapper) {
        this.diagnosticoRepository = diagnosticoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.enfermedadRepository = enfermedadRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveDiagnostico(CrearDiagnosticoDTO crearDiagnosticoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        DiagnosticoEntity diagnosticoEntity = new DiagnosticoEntity();
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(crearDiagnosticoDTO.getPacienteId());
        pacienteEntity.ifPresent(diagnosticoEntity::setPacienteEntity);
        Optional<EnfermedadEntity> enfermedadEntity = enfermedadRepository.findById(crearDiagnosticoDTO.getEnfermedadId());
        enfermedadEntity.ifPresent(diagnosticoEntity::setEnfermedadEntity);
        diagnosticoEntity.setFecha(crearDiagnosticoDTO.getFecha());
        diagnosticoEntity.setDescripcion(crearDiagnosticoDTO.getDescripcion());
        diagnosticoEntity.setHospital(hospital);
        diagnosticoEntity.setUser(user);
        diagnosticoRepository.save(diagnosticoEntity);
        return new ApiResponse(true, "Diagnostico del paciente creado correctamente");
    }

    @Override
    public ListResponse<DiagnosticoDTO> getAllDiagnotico(UUID pacienteDiagnosticoId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<DiagnosticoEntity>  diagnosticoEntityPage = diagnosticoRepository.findByHospital_HospitalId(pacienteDiagnosticoId, pageable);
        List<DiagnosticoDTO> data = diagnosticoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, diagnosticoEntityPage.getTotalElements(), diagnosticoEntityPage.getTotalPages(), diagnosticoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateDiagnostico(UUID pacienteDiagnosticoId, ActualizarDiagnosticoDTO actualizarDiagnosticoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        DiagnosticoEntity diagnosticoEntity = diagnosticoRepository.findById(pacienteDiagnosticoId).orElseThrow(
                () -> new ResourceNotFoundException("Diagnostico del paciente no encontrado"));
        Optional.ofNullable(actualizarDiagnosticoDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(diagnosticoEntity::setPacienteEntity);
        Optional.ofNullable(actualizarDiagnosticoDTO.getEnfermedadId()).flatMap(enfermedadRepository::findById).ifPresent(diagnosticoEntity::setEnfermedadEntity);
        Optional.ofNullable(actualizarDiagnosticoDTO.getFecha()).ifPresent(diagnosticoEntity::setFecha);
        Optional.ofNullable(actualizarDiagnosticoDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoEntity::setDescripcion);
        diagnosticoRepository.save(diagnosticoEntity);
        return new ApiResponse(true, "Diagnostico del paciente modificado correctamente");
    }

    @Override
    public DiagnosticoDTO getDiagnosticoById(UUID pacienteDiagnosticoId) {
        DiagnosticoEntity diagnosticoEntity = diagnosticoRepository.findById(pacienteDiagnosticoId).orElseThrow(
                () -> new ResourceNotFoundException("Diagnostico del paciente no encontrado"));
        return convertToDTO(diagnosticoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteDiagnostico(UUID pacienteDiagnosticoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        diagnosticoRepository.deleteById(pacienteDiagnosticoId);
        return new ApiResponse(true, "Diagnostico del paciente eliminado correctamente");
    }

    private DiagnosticoDTO convertToDTO(DiagnosticoEntity diagnosticoEntity) {
        return modelMapper.map(diagnosticoEntity, DiagnosticoDTO.class);
    }

}