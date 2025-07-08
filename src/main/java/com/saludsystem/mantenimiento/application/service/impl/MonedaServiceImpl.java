package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.MonedaResponse;
import com.saludsystem.mantenimiento.application.dto.req.MonedaRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.MonedaService;
import com.saludsystem.mantenimiento.domain.model.MonedaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.MonedaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MonedaServiceImpl extends GenericServiceImpl<MonedaEntity, MonedaRequest, MonedaResponse, UUID>
        implements MonedaService {

    protected MonedaServiceImpl(
            MonedaRepository monedaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(monedaRepository, modelMapper, authValidator, MonedaResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(MonedaRequest monedaRequest) {
        return super.save(monedaRequest);
    }

    @Override
    public ListResponse<MonedaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, MonedaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<MonedaResponse> getList() {
        return super.getList();
    }

    @Override
    public MonedaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected MonedaEntity convertCreateDtoToEntity(MonedaRequest monedaRequest) {
        MonedaEntity entity = new MonedaEntity();
        entity.setDescripcion(monedaRequest.getDescripcion());
        entity.setEstado(monedaRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(MonedaEntity entity, MonedaRequest dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}