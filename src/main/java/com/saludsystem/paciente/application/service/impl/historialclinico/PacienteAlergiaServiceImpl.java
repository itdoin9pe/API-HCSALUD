package com.saludsystem.paciente.application.service.impl.historialclinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.CrearPacienteAlergiaDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.ActualizarPacienteAlergiaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.PacienteAlergiaService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.historialclinico.PacienteAlergiaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.AlergiaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.historialclinico.PacienteAlergiaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PacienteAlergiaServiceImpl extends GenericServiceImpl<PacienteAlergiaEntity, PacienteAlergiaDTO,
        CrearPacienteAlergiaDTO, ActualizarPacienteAlergiaDTO, UUID> implements PacienteAlergiaService {

    private final PacienteRepository pacienteRepository;
    private final AlergiaRepository alergiaRepository;

    public PacienteAlergiaServiceImpl(
            PacienteAlergiaRepository pacienteAlergiaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, AlergiaRepository alergiaRepository) {
        super(pacienteAlergiaRepository, modelMapper, authValidator, PacienteAlergiaDTO.class
        );
        this.pacienteRepository = pacienteRepository;
        this.alergiaRepository = alergiaRepository;
    }

    @Override
    protected PacienteAlergiaEntity convertCreateDtoToEntity(CrearPacienteAlergiaDTO crearPacienteAlergiaDTO) {
        PacienteAlergiaEntity entity = new PacienteAlergiaEntity();
        entity.setPacienteEntity(pacienteRepository.findById(crearPacienteAlergiaDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setAlergiaEntity(alergiaRepository.findById(crearPacienteAlergiaDTO.getAlergiaId())
                .orElseThrow( () -> new ResourceNotFoundException("Alergia not found")));
        entity.setObservacion(crearPacienteAlergiaDTO.getObservacion());
        entity.setEstado(crearPacienteAlergiaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PacienteAlergiaEntity entity, ActualizarPacienteAlergiaDTO dto) {
        entity.setPacienteEntity(pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setAlergiaEntity(alergiaRepository.findById(dto.getAlergiaId())
                .orElseThrow( () -> new ResourceNotFoundException("Alergia not found")));
        entity.setObservacion(dto.getObservacion());
        entity.setEstado(dto.getEstado());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPacienteAlergiaDTO crearPacienteAlergiaDTO) {
        return super.save(crearPacienteAlergiaDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarPacienteAlergiaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}