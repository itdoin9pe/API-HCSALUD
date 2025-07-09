package com.saludsystem.paciente.application.service.impl.historialclinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.ActualizarExploracionFisicaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.ExploracionFisicaService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.HistorialClinico.ExploracionFisicaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.HistorialClinico.ExploracionFisicaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExploracionFisicaServiceImpl extends GenericServiceImpl<ExploracionFisicaEntity, ExploracionFisicaDTO,
        CrearExploracionFisicaDTO, ActualizarExploracionFisicaDTO, UUID> implements ExploracionFisicaService {

    private final PacienteRepository pacienteRepository;

    public ExploracionFisicaServiceImpl(
            ExploracionFisicaRepository exploracionFisicaRepository,
            ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(exploracionFisicaRepository, modelMapper, authValidator, ExploracionFisicaDTO.class);
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected ExploracionFisicaEntity convertCreateDtoToEntity(CrearExploracionFisicaDTO exploracionFisicaRequest) {
        ExploracionFisicaEntity entity = new ExploracionFisicaEntity();
        entity.setPacienteEntity(pacienteRepository.findById(exploracionFisicaRequest.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setPresionArterial(exploracionFisicaRequest.getPresionArterial());
        entity.setPulso(exploracionFisicaRequest.getPulso());
        entity.setTemperatura(exploracionFisicaRequest.getTemperatura());
        entity.setFrecuenciaCardiaca(exploracionFisicaRequest.getFrecuenciaCardiaca());
        entity.setFrecuenciaRespiratoria(exploracionFisicaRequest.getFrecuenciaRespiratoria());
        entity.setPeso(exploracionFisicaRequest.getPeso());
        entity.setTalla(exploracionFisicaRequest.getTalla());
        entity.setMasa(exploracionFisicaRequest.getMasa());
        entity.setExamenClinico(exploracionFisicaRequest.getExamenClinico());
        entity.setComplementoExamen(exploracionFisicaRequest.getComplementoExamen());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ExploracionFisicaEntity entity, ActualizarExploracionFisicaDTO dto) {
        entity.setPacienteEntity(pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setPresionArterial(dto.getPresionArterial());
        entity.setPulso(dto.getPulso());
        entity.setTemperatura(dto.getTemperatura());
        entity.setFrecuenciaCardiaca(dto.getFrecuenciaCardiaca());
        entity.setFrecuenciaRespiratoria(dto.getFrecuenciaRespiratoria());
        entity.setPeso(dto.getPeso());
        entity.setTalla(dto.getTalla());
        entity.setMasa(dto.getMasa());
        entity.setExamenClinico(dto.getExamenClinico());
        entity.setComplementoExamen(dto.getComplementoExamen());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearExploracionFisicaDTO exploracionFisicaRequest) {
        return super.save(exploracionFisicaRequest);
    }

    @Override
    public ListResponse<ExploracionFisicaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarExploracionFisicaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public ExploracionFisicaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ExploracionFisicaDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}