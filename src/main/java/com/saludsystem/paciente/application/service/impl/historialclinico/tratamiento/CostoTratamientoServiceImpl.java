package com.saludsystem.paciente.application.service.impl.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.CostoTratamientoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.CostoTratamientoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.tratamiento.CostoTratamientoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.Tratamiento.CostoTratamientoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.Tratamiento.CostoTratamientoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.Tratamiento.PlanTratamientoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CostoTratamientoServiceImpl extends GenericServiceImpl<CostoTratamientoEntity, CostoTratamientoRequest,
        CostoTratamientoResponse, UUID> implements CostoTratamientoService {

    private final PacienteRepository pacienteRepository;
    private final PlanTratamientoRepository planTratamientoRepository;

    public CostoTratamientoServiceImpl(
            CostoTratamientoRepository costoTratamientoRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, PlanTratamientoRepository planTratamientoRepository) {
        super(costoTratamientoRepository, modelMapper, authValidator, CostoTratamientoResponse.class
        );
        this.pacienteRepository = pacienteRepository;
        this.planTratamientoRepository = planTratamientoRepository;
    }

    @Override
    protected CostoTratamientoEntity convertCreateDtoToEntity(CostoTratamientoRequest costoTratamientoRequest) {
        CostoTratamientoEntity entity = new CostoTratamientoEntity();
        entity.setPacienteEntity(pacienteRepository.findById(costoTratamientoRequest.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setPlanTratamientoEntity(planTratamientoRepository.findById(costoTratamientoRequest.getPacientePlanTratamientoId())
                .orElseThrow( () -> new ResourceNotFoundException("Plan de tratamiento not found")));
        entity.setConcepto(costoTratamientoRequest.getConcepto());
        entity.setMonto(costoTratamientoRequest.getMonto());
        entity.setMoneda(costoTratamientoRequest.getMoneda());
        entity.setPagado(costoTratamientoRequest.isPagado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CostoTratamientoEntity entity, CostoTratamientoRequest dto) {
        entity.setPacienteEntity(pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found")));
        entity.setPlanTratamientoEntity(planTratamientoRepository.findById(dto.getPacientePlanTratamientoId())
                .orElseThrow( () -> new ResourceNotFoundException("Plan de tratamiento not found")));
        entity.setConcepto(dto.getConcepto());
        entity.setMonto(dto.getMonto());
        entity.setMoneda(dto.getMoneda());
        entity.setPagado(dto.isPagado());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CostoTratamientoRequest costoTratamientoRequest) {
        return super.save(costoTratamientoRequest);
    }

    @Override
    public ListResponse<CostoTratamientoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CostoTratamientoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<CostoTratamientoResponse> getList() {
        return super.getList();
    }

    @Override
    public CostoTratamientoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}