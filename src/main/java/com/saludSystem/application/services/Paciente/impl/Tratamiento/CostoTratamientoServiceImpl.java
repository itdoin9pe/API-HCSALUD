package com.saludSystem.application.services.Paciente.impl.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.CostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearCostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarCostoTratamientoDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.Tratamiento.CostoTratamientoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Paciente.Tratamiento.CostoTratamientoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento.CostoTratamientoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento.PlanTratamientoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CostoTratamientoServiceImpl extends GenericServiceImpl<CostoTratamientoEntity, CostoTratamientoDTO,
        UUID, CrearCostoTratamientoDTO, ActualizarCostoTratamientoDTO> implements CostoTratamientoService {

    private final PacienteRepository pacienteRepository;
    private final PlanTratamientoRepository planTratamientoRepository;

    public CostoTratamientoServiceImpl(
            CostoTratamientoRepository costoTratamientoRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, PlanTratamientoRepository planTratamientoRepository) {
        super(costoTratamientoRepository, modelMapper, authValidator, CostoTratamientoDTO.class,
                costoTratamientoEntity ->
                        modelMapper.map(costoTratamientoEntity, CostoTratamientoDTO.class));
        this.pacienteRepository = pacienteRepository;
        this.planTratamientoRepository = planTratamientoRepository;
    }

    @Override
    protected CostoTratamientoEntity convertCreateDtoToEntity(CrearCostoTratamientoDTO crearCostoTratamientoDTO) {
        CostoTratamientoEntity entity = new CostoTratamientoEntity();
        entity.setPacienteEntity(pacienteRepository.findById(crearCostoTratamientoDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setPlanTratamientoEntity(planTratamientoRepository.findById(crearCostoTratamientoDTO.getPacientePlanTratamientoId())
                .orElseThrow( () -> new ResourceNotFoundException("Plan de tratamiento not found")));
        entity.setConcepto(crearCostoTratamientoDTO.getConcepto());
        entity.setMonto(crearCostoTratamientoDTO.getMonto());
        entity.setMoneda(crearCostoTratamientoDTO.getMoneda());
        entity.setPagado(crearCostoTratamientoDTO.isPagado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarCostoTratamientoDTO actualizarCostoTratamientoDTO, CostoTratamientoEntity entity) {
        entity.setPacienteEntity(pacienteRepository.findById(actualizarCostoTratamientoDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setPlanTratamientoEntity(planTratamientoRepository.findById(actualizarCostoTratamientoDTO.getPacientePlanTratamientoId())
                .orElseThrow( () -> new ResourceNotFoundException("Plan de tratamiento not found")));
        entity.setConcepto(actualizarCostoTratamientoDTO.getConcepto());
        entity.setMonto(actualizarCostoTratamientoDTO.getMonto());
        entity.setMoneda(actualizarCostoTratamientoDTO.getMoneda());
        entity.setPagado(actualizarCostoTratamientoDTO.isPagado());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearCostoTratamientoDTO crearCostoTratamientoDTO) {
        return super.save(crearCostoTratamientoDTO);
    }

    @Override
    public ListResponse<CostoTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarCostoTratamientoDTO actualizarCostoTratamientoDTO) {
        return super.update(uuid, actualizarCostoTratamientoDTO);
    }

    @Override
    public List<CostoTratamientoDTO> getList() {
        return super.getList();
    }

    @Override
    public CostoTratamientoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}