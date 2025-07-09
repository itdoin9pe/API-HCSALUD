package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.get.DiagnosticoDTO;
import com.saludsystem.paciente.application.dto.post.CrearDiagnosticoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarDiagnosticoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.DiagnosticoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.mantenimiento.domain.model.EnfermedadEntity;
import com.saludsystem.paciente.domain.model.DiagnosticoEntity;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.EnfermedadRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.DiagnosticoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DiagnosticoServiceImpl extends GenericServiceImpl<DiagnosticoEntity, DiagnosticoDTO,
        CrearDiagnosticoDTO, ActualizarDiagnosticoDTO, UUID> implements DiagnosticoService {

    private final PacienteRepository pacienteRepository;
    private final EnfermedadRepository enfermedadRepository;

    public DiagnosticoServiceImpl(
            DiagnosticoRepository diagnosticoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, PacienteRepository pacienteRepository, EnfermedadRepository enfermedadRepository) {
        super(diagnosticoRepository, modelMapper, authValidator, DiagnosticoDTO.class
        );
        this.pacienteRepository = pacienteRepository;
        this.enfermedadRepository = enfermedadRepository;
    }

    @Override
    protected DiagnosticoEntity convertCreateDtoToEntity(CrearDiagnosticoDTO crearDiagnosticoDTO) {
        DiagnosticoEntity entity = new DiagnosticoEntity();
        PacienteEntity paciente = pacienteRepository.findById(crearDiagnosticoDTO.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
        entity.setPacienteEntity(paciente);
        EnfermedadEntity enfermedad = enfermedadRepository.findById(crearDiagnosticoDTO.getEnfermedadId())
                .orElseThrow(() -> new ResourceNotFoundException("Enfermedad no encontrada"));
        entity.setEnfermedadEntity(enfermedad);
        entity.setFecha(crearDiagnosticoDTO.getFecha());
        entity.setDescripcion(crearDiagnosticoDTO.getDescripcion());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(DiagnosticoEntity entity, ActualizarDiagnosticoDTO dto) {
        Optional.ofNullable(dto.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getEnfermedadId())
                .flatMap(enfermedadRepository::findById)
                .ifPresent(entity::setEnfermedadEntity);
        Optional.ofNullable(dto.getFecha()).ifPresent(entity::setFecha);
        Optional.ofNullable(dto.getDescripcion())
                .filter(desc -> !desc.isBlank())
                .ifPresent(entity::setDescripcion);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearDiagnosticoDTO crearDiagnosticoDTO) {
        return super.save(crearDiagnosticoDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarDiagnosticoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}