package com.saludSystem.application.services.Paciente.impl.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarExploracionFisicaDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.HistorialClinico.ExploracionFisicaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Paciente.HistorialClinico.ExploracionFisicaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico.ExploracionFisicaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExploracionFisicaServiceImpl extends GenericServiceImpl<ExploracionFisicaEntity, ExploracionFisicaDTO,
        UUID, CrearExploracionFisicaDTO, ActualizarExploracionFisicaDTO> implements ExploracionFisicaService {

    private final PacienteRepository pacienteRepository;

    public ExploracionFisicaServiceImpl(
            ExploracionFisicaRepository exploracionFisicaRepository,
            ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(exploracionFisicaRepository, modelMapper, authValidator, ExploracionFisicaDTO.class,
                exploracionFisicaEntity ->
                        modelMapper.map(exploracionFisicaEntity, ExploracionFisicaDTO.class));
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
    protected void updateEntityFromDto(ActualizarExploracionFisicaDTO actualizarExploracionFisicaDTO, ExploracionFisicaEntity entity) {
        entity.setPacienteEntity(pacienteRepository.findById(actualizarExploracionFisicaDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setPresionArterial(actualizarExploracionFisicaDTO.getPresionArterial());
        entity.setPulso(actualizarExploracionFisicaDTO.getPulso());
        entity.setTemperatura(actualizarExploracionFisicaDTO.getTemperatura());
        entity.setFrecuenciaCardiaca(actualizarExploracionFisicaDTO.getFrecuenciaCardiaca());
        entity.setFrecuenciaRespiratoria(actualizarExploracionFisicaDTO.getFrecuenciaRespiratoria());
        entity.setPeso(actualizarExploracionFisicaDTO.getPeso());
        entity.setTalla(actualizarExploracionFisicaDTO.getTalla());
        entity.setMasa(actualizarExploracionFisicaDTO.getMasa());
        entity.setExamenClinico(actualizarExploracionFisicaDTO.getExamenClinico());
        entity.setComplementoExamen(actualizarExploracionFisicaDTO.getComplementoExamen());
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
    public ApiResponse update(UUID uuid, ActualizarExploracionFisicaDTO actualizarExploracionFisicaDTO) {
        return super.update(uuid, actualizarExploracionFisicaDTO);
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