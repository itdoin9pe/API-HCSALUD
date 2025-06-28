package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.DiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearDiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarDiagnosticoDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.DiagnosticoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Mantenimiento.EnfermedadEntity;
import com.saludSystem.domain.model.Paciente.DiagnosticoEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.EnfermedadRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.DiagnosticoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
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