package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisOclusal1DTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAnalisisOclusal1DTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAnalisisOclusal1DTO;
import com.saludSystem.application.services.Paciente.AnalisisOclusal1Service;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.AnalisisOclusal1Entity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.AnalisisOclusal1Repository;
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
public class AnalisisOclusal1ServiceImpl implements AnalisisOclusal1Service {

    private final AnalisisOclusal1Repository analisisOclusal1Repository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public AnalisisOclusal1ServiceImpl(AnalisisOclusal1Repository analisisOclusal1Repository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.analisisOclusal1Repository = analisisOclusal1Repository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveAnalisis1Oclusal(CrearAnalisisOclusal1DTO crearAnalisisOclusal1DTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        AnalisisOclusal1Entity analisisOclusal1Entity = new AnalisisOclusal1Entity();
        PacienteEntity paciente = pacienteRepository.findById(crearAnalisisOclusal1DTO.getPacienteId())
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado con ID: " + crearAnalisisOclusal1DTO.getPacienteId()));
        analisisOclusal1Repository.save(analisisOclusal1Entity);
        return new ApiResponse(true, "Analisis oclusal de lista 1 completado");
    }

    @Override
    public ApiResponse deleteAnalisis1Oclusal(UUID pacienteAnalisisOclusal1Id) {
        analisisOclusal1Repository.deleteById(pacienteAnalisisOclusal1Id);
        return new ApiResponse(true, "Analisis Oclusal 1 eliminado correctamente");
    }

    @Override
    public AnalisisOclusal1DTO getAnalisisOclusal1ById(UUID pacienteAnalisisOclusal1Id) {
        AnalisisOclusal1Entity analisisOclusal1Entity = analisisOclusal1Repository.findById(pacienteAnalisisOclusal1Id).
                orElseThrow( () -> new ResourceNotFoundException("Analisis Oclusal 1 no encontrado"));
        return convertToDTO(analisisOclusal1Entity);
    }

    @Override
    public ApiResponse updateAnalisisOclusal1(UUID pacienteAnalisisOclusal1Id, ActualizarAnalisisOclusal1DTO actualizarAnalisisOclusal1DTO) {
        AnalisisOclusal1Entity analisisOclusal1Entity = analisisOclusal1Repository.findById(pacienteAnalisisOclusal1Id).
                orElseThrow( () -> new ResourceNotFoundException("Analisis Oclusal 1 no encontrado"));
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(analisisOclusal1Entity::setPacienteEntity);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getMandibula()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setMandibula);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getTransversal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setTransversal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getDerechoOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setDerechoOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getIzquierdoOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setIzquierdoOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getVerticalOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setVerticalOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getMordidaOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setMordidaOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getMmOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setMmOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getCurvaspeeoclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setCurvaspeeoclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getInferioresOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setInferioresOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getIncisivosOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setIncisivosOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getIntrusionOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setIntrusionOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getMolaresOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setMolaresOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getMolaresInstrusivosOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setMolaresInstrusivosOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getSagitaloclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setSagitaloclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getMm2Oclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setMm2Oclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getCaninoDerechoOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setCaninoDerechoOclusal);
        Optional.ofNullable(actualizarAnalisisOclusal1DTO.getCaninoIzquierdoOclusal()).filter(desc -> !desc.isBlank()).ifPresent(analisisOclusal1Entity::setCaninoIzquierdoOclusal);
        analisisOclusal1Repository.save(analisisOclusal1Entity);
        return new ApiResponse(true, "Analisis Oclusal de seccion 1 modificado correctamente");
    }

    @Override
    public ListResponse<AnalisisOclusal1DTO> getAllAnalisisOclusal1(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AnalisisOclusal1Entity> analisisOclusal1EntityPage = analisisOclusal1Repository.findByHospital_HospitalId(hospitalId, pageable);
        List<AnalisisOclusal1DTO> data = analisisOclusal1EntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, analisisOclusal1EntityPage.getTotalElements(), analisisOclusal1EntityPage.getTotalPages(), analisisOclusal1EntityPage.getNumber() + 1);
    }

    private AnalisisOclusal1DTO convertToDTO(AnalisisOclusal1Entity analisisOclusal1Entity) {
        return modelMapper.map(analisisOclusal1Entity, AnalisisOclusal1DTO.class);
    }

}