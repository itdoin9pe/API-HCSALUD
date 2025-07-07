package com.saludsystem.application.services.paciente.impl.historialclinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialclinico.ExploracionFisicaService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.HistorialClinico.ExploracionFisicaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.HistorialClinico.ExploracionFisicaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExploracionFisicaServiceImpl extends GenericServiceImpl<ExploracionFisicaEntity, CrearExploracionFisicaDTO,
        ExploracionFisicaDTO, UUID> implements ExploracionFisicaService {

    private final PacienteRepository pacienteRepository;

    public ExploracionFisicaServiceImpl(
            ExploracionFisicaRepository exploracionFisicaRepository,
            ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(exploracionFisicaRepository, modelMapper, authValidator, ExploracionFisicaDTO.class);
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected ExploracionFisicaEntity convertCreateDtoToEntity(CrearExploracionFisicaDTO crearExploracionFisicaDTO) {
        ExploracionFisicaEntity entity = new ExploracionFisicaEntity();
        entity.setPacienteEntity(pacienteRepository.findById(crearExploracionFisicaDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setPresionArterial(crearExploracionFisicaDTO.getPresionArterial());
        entity.setPulso(crearExploracionFisicaDTO.getPulso());
        entity.setTemperatura(crearExploracionFisicaDTO.getTemperatura());
        entity.setFrecuenciaCardiaca(crearExploracionFisicaDTO.getFrecuenciaCardiaca());
        entity.setFrecuenciaRespiratoria(crearExploracionFisicaDTO.getFrecuenciaRespiratoria());
        entity.setPeso(crearExploracionFisicaDTO.getPeso());
        entity.setTalla(crearExploracionFisicaDTO.getTalla());
        entity.setMasa(crearExploracionFisicaDTO.getMasa());
        entity.setExamenClinico(crearExploracionFisicaDTO.getExamenClinico());
        entity.setComplementoExamen(crearExploracionFisicaDTO.getComplementoExamen());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ExploracionFisicaEntity entity, CrearExploracionFisicaDTO dto) {
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
    public ApiResponse save(CrearExploracionFisicaDTO crearExploracionFisicaDTO) {
        return super.save(crearExploracionFisicaDTO);
    }

    @Override
    public ListResponse<ExploracionFisicaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CrearExploracionFisicaDTO updateDto) {
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