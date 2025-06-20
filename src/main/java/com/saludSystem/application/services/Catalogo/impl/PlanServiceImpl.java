package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarPlanDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearPlanDTO;
import com.saludSystem.application.dtos.Catalogo.GET.PlanDTO;
import com.saludSystem.application.services.Catalogo.PlanService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Catalogo.PlanEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.PlanRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.UUID;

@Service
public class PlanServiceImpl extends GenericServiceImpl<PlanEntity, PlanDTO, UUID, CrearPlanDTO, ActualizarPlanDTO>
        implements PlanService {

    public PlanServiceImpl(PlanRepository planRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(planRepository, modelMapper, authValidator, PlanDTO.class,
                planEntity -> modelMapper.map(planEntity, PlanDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearPlanDTO crearPlanDTO) {
        return super.save(crearPlanDTO);
    }

    @Override
    public ListResponse<PlanDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarPlanDTO actualizarPlanDTO) {
        return super.update(uuid, actualizarPlanDTO);
    }

    @Override
    public List<PlanDTO> getList() {
        return super.getList();
    }

    @Override
    public PlanDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected PlanEntity convertCreateDtoToEntity(CrearPlanDTO crearPlanDTO) {
        PlanEntity entity = new PlanEntity();
        entity.setNombrePlan(crearPlanDTO.getNombrePlan());
        entity.setCostoPlan(crearPlanDTO.getCostoPlan());
        entity.setFechaInicio(crearPlanDTO.getFechaInicio());
        entity.setFechaFinContrato(crearPlanDTO.getFechaFinContrato());
        entity.setUsuMax(crearPlanDTO.getUseMax());
        entity.setMaxPlan(crearPlanDTO.getMaxPlan());
        entity.setEstado(crearPlanDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarPlanDTO actualizarPlanDTO, PlanEntity entity) {
        entity.setNombrePlan(actualizarPlanDTO.getNombrePlan());
        entity.setCostoPlan(actualizarPlanDTO.getCostoPlan());
        entity.setFechaInicio(actualizarPlanDTO.getFechaInicio());
        entity.setFechaFinContrato(actualizarPlanDTO.getFechaFinContrato());
        entity.setUsuMax(actualizarPlanDTO.getUseMax());
        entity.setMaxPlan(actualizarPlanDTO.getMaxPlan());
        entity.setEstado(actualizarPlanDTO.getEstado());
    }
}