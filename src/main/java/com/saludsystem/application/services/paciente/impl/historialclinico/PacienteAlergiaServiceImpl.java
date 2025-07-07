package com.saludsystem.application.services.paciente.impl.historialclinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearPacienteAlergiaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialclinico.PacienteAlergiaService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.HistorialClinico.PacienteAlergiaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.AlergiaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.HistorialClinico.PacienteAlergiaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteAlergiaServiceImpl extends GenericServiceImpl<PacienteAlergiaEntity,CrearPacienteAlergiaDTO,
        PacienteAlergiaDTO, UUID> implements PacienteAlergiaService {

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
    protected void updateEntityFromDto(PacienteAlergiaEntity entity, CrearPacienteAlergiaDTO dto) {
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

    @Override
    public ListResponse<PacienteAlergiaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CrearPacienteAlergiaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<PacienteAlergiaDTO> getList() {
        return super.getList();
    }

    @Override
    public PacienteAlergiaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}