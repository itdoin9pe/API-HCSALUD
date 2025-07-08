package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.res.TipoMaterialResponse;
import com.saludsystem.operaciones.application.dto.req.TipoMaterialRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.TipoMaterialService;
import com.saludsystem.operaciones.domain.model.TipoMaterialEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.TipoMaterialRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoMaterialServiceImpl extends GenericServiceImpl<TipoMaterialEntity, TipoMaterialRequest,
        TipoMaterialResponse, UUID> implements TipoMaterialService {

    public TipoMaterialServiceImpl(
            TipoMaterialRepository tipoMaterialRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoMaterialRepository, modelMapper, authValidator, TipoMaterialResponse.class);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(TipoMaterialRequest tipoMaterialRequest) {
        return super.save(tipoMaterialRequest);
    }

    @Override
    public ListResponse<TipoMaterialResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, TipoMaterialRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoMaterialResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoMaterialResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoMaterialEntity convertCreateDtoToEntity(TipoMaterialRequest tipoMaterialRequest) {
        TipoMaterialEntity entity = new TipoMaterialEntity();
        entity.setNombre(tipoMaterialRequest.getNombre());
        entity.setDescripcion(tipoMaterialRequest.getDescripcion());
        entity.setEstado(tipoMaterialRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoMaterialEntity entity, TipoMaterialRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}