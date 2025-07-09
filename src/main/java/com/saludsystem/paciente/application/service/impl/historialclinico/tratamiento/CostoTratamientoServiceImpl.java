package com.saludsystem.paciente.application.service.impl.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento.CostoTratamientoDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.tratamiento.CrearCostoTratamientoDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.tratamiento.ActualizarCostoTratamientoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.tratamiento.CostoTratamientoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.tratamiento.CostoTratamientoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.tratamiento.CostoTratamientoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.tratamiento.PlanTratamientoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CostoTratamientoServiceImpl extends GenericServiceImpl<CostoTratamientoEntity, CostoTratamientoDTO,
        CrearCostoTratamientoDTO, ActualizarCostoTratamientoDTO, UUID> implements CostoTratamientoService {

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
    protected void updateEntityFromDto(CostoTratamientoEntity entity, ActualizarCostoTratamientoDTO dto) {
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

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarCostoTratamientoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}