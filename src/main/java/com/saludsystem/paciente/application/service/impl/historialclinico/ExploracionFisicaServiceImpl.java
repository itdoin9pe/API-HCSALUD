package com.saludsystem.paciente.application.service.impl.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.ExploracionFisicaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.ExploracionFisicaRequest;
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
public class ExploracionFisicaServiceImpl extends GenericServiceImpl<ExploracionFisicaEntity, ExploracionFisicaRequest,
        ExploracionFisicaResponse, UUID> implements ExploracionFisicaService {

    private final PacienteRepository pacienteRepository;

    public ExploracionFisicaServiceImpl(
            ExploracionFisicaRepository exploracionFisicaRepository,
            ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(exploracionFisicaRepository, modelMapper, authValidator, ExploracionFisicaResponse.class);
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected ExploracionFisicaEntity convertCreateDtoToEntity(ExploracionFisicaRequest exploracionFisicaRequest) {
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
    protected void updateEntityFromDto(ExploracionFisicaEntity entity, ExploracionFisicaRequest dto) {
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
    public ApiResponse save(ExploracionFisicaRequest exploracionFisicaRequest) {
        return super.save(exploracionFisicaRequest);
    }

    @Override
    public ListResponse<ExploracionFisicaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ExploracionFisicaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public ExploracionFisicaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ExploracionFisicaResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}