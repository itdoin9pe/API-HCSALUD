package com.saludsystem.application.services.paciente.impl.historialclinico.tratamiento;

import com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento.CostoTratamientoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialclinico.tratamiento.CostoTratamientoService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.Tratamiento.CostoTratamientoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Tratamiento.CostoTratamientoRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Tratamiento.PlanTratamientoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CostoTratamientoServiceImpl extends GenericServiceImpl<CostoTratamientoEntity, CrearCostoTratamientoDTO,
        CostoTratamientoDTO, UUID> implements CostoTratamientoService {

    private final PacienteRepository pacienteRepository;
    private final PlanTratamientoRepository planTratamientoRepository;

    public CostoTratamientoServiceImpl(
            CostoTratamientoRepository costoTratamientoRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, PlanTratamientoRepository planTratamientoRepository) {
        super(costoTratamientoRepository, modelMapper, authValidator, CostoTratamientoDTO.class
        );
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
    protected void updateEntityFromDto(CostoTratamientoEntity entity, CrearCostoTratamientoDTO dto) {
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
    public ApiResponse save(CrearCostoTratamientoDTO crearCostoTratamientoDTO) {
        return super.save(crearCostoTratamientoDTO);
    }

    @Override
    public ListResponse<CostoTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CrearCostoTratamientoDTO updateDto) {
        return super.update(uuid, updateDto);
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