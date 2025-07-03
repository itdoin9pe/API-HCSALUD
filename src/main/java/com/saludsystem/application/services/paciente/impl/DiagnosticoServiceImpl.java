package com.saludsystem.application.services.paciente.impl;

import com.saludsystem.application.dtos.paciente.get.DiagnosticoDTO;
import com.saludsystem.application.dtos.paciente.post.CrearDiagnosticoDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarDiagnosticoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.DiagnosticoService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.mantenimiento.EnfermedadEntity;
import com.saludsystem.domain.model.paciente.DiagnosticoEntity;
import com.saludsystem.domain.model.paciente.PacienteEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.EnfermedadRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.DiagnosticoRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiagnosticoServiceImpl extends GenericServiceImpl<DiagnosticoEntity, DiagnosticoDTO, UUID,
        CrearDiagnosticoDTO, ActualizarDiagnosticoDTO> implements DiagnosticoService {

    private final PacienteRepository pacienteRepository;
    private final EnfermedadRepository enfermedadRepository;

    public DiagnosticoServiceImpl(
            DiagnosticoRepository diagnosticoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, PacienteRepository pacienteRepository, EnfermedadRepository enfermedadRepository) {
        super(diagnosticoRepository, modelMapper, authValidator, DiagnosticoDTO.class,
                diagnosticoEntity -> modelMapper.map(diagnosticoEntity, DiagnosticoDTO.class));
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
    protected void updateEntityFromDto(ActualizarDiagnosticoDTO actualizarDiagnosticoDTO, DiagnosticoEntity entity) {
        Optional.ofNullable(actualizarDiagnosticoDTO.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(actualizarDiagnosticoDTO.getEnfermedadId())
                .flatMap(enfermedadRepository::findById)
                .ifPresent(entity::setEnfermedadEntity);
        Optional.ofNullable(actualizarDiagnosticoDTO.getFecha()).ifPresent(entity::setFecha);
        Optional.ofNullable(actualizarDiagnosticoDTO.getDescripcion())
                .filter(desc -> !desc.isBlank())
                .ifPresent(entity::setDescripcion);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearDiagnosticoDTO crearDiagnosticoDTO) {
        return super.save(crearDiagnosticoDTO);
    }

    @Override
    public ListResponse<DiagnosticoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarDiagnosticoDTO actualizarDiagnosticoDTO) {
        return super.update(uuid, actualizarDiagnosticoDTO);
    }

    @Override
    public DiagnosticoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<DiagnosticoDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}