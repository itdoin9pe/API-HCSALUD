package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.PlanRequest;
import com.saludsystem.catalogo.application.services.PlanService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.PlanEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.PlanRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlanServiceImpl extends GenericServiceImpl<PlanEntity, com.saludsystem.catalogo.application.dtos.req.PlanRequest, PlanRequest, UUID>
        implements PlanService {

    protected PlanServiceImpl(PlanRepository planRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(planRepository, modelMapper, authValidator, PlanRequest.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(com.saludsystem.catalogo.application.dtos.req.PlanRequest crearPlanRequest) {
        return super.save(crearPlanRequest);
    }

    @Override
    public ListResponse<PlanRequest> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, com.saludsystem.catalogo.application.dtos.req.PlanRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<PlanRequest> getList() {
        return super.getList();
    }

    @Override
    public PlanRequest getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected PlanEntity convertCreateDtoToEntity(com.saludsystem.catalogo.application.dtos.req.PlanRequest crearPlanRequest) {
        PlanEntity entity = new PlanEntity();
        entity.setNombrePlan(crearPlanRequest.getNombrePlan());
        entity.setCostoPlan(crearPlanRequest.getCostoPlan());
        entity.setFechaInicio(crearPlanRequest.getFechaInicio());
        entity.setFechaFinContrato(crearPlanRequest.getFechaFinContrato());
        entity.setUsuMax(crearPlanRequest.getUseMax());
        entity.setMaxPlan(crearPlanRequest.getMaxPlan());
        entity.setEstado(crearPlanRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PlanEntity entity, com.saludsystem.catalogo.application.dtos.req.PlanRequest dto) {
        Optional.ofNullable(dto.getNombrePlan()).ifPresent(entity::setNombrePlan);
        Optional.ofNullable(dto.getCostoPlan()).ifPresent(entity::setCostoPlan);
        Optional.ofNullable(dto.getFechaInicio()).ifPresent(entity::setFechaInicio);
        Optional.ofNullable(dto.getFechaFinContrato()).ifPresent(entity::setFechaFinContrato);
        Optional.ofNullable(dto.getUseMax()).ifPresent(entity::setUsuMax);
        Optional.ofNullable(dto.getMaxPlan()).ifPresent(entity::setMaxPlan);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }

}