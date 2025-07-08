package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.res.PresentacionResponse;
import com.saludsystem.operaciones.application.dto.req.PresentacionRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.PresentacionService;
import com.saludsystem.operaciones.domain.model.PresentacionEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.PresentacionReposirory;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PresentacionServiceImpl extends GenericServiceImpl<PresentacionEntity, PresentacionRequest,
        PresentacionResponse, UUID> implements PresentacionService {

    public PresentacionServiceImpl(
            PresentacionReposirory presentacionReposirory, ModelMapper modelMapper, AuthValidator authValidator) {
        super(presentacionReposirory, modelMapper, authValidator, PresentacionResponse.class
        );
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(PresentacionRequest presentacionRequest) {
        return super.save(presentacionRequest);
    }

    @Override
    public ListResponse<PresentacionResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, PresentacionRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public PresentacionResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<PresentacionResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected PresentacionEntity convertCreateDtoToEntity(PresentacionRequest presentacionRequest) {
        PresentacionEntity entity = new PresentacionEntity();
        entity.setNombre(presentacionRequest.getNombre());
        entity.setEstado(presentacionRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PresentacionEntity entity, PresentacionRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}