package com.saludsystem.configuracion.application.services.impl;

import com.saludsystem.configuracion.application.dto.res.PermisoResponse;
import com.saludsystem.configuracion.application.dto.req.PermisoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.configuracion.application.services.PermisoService;
import com.saludsystem.configuracion.domain.model.PermisoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.PermisoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PermisoServiceImpl extends GenericServiceImpl<PermisoEntity, PermisoRequest, PermisoResponse, UUID>
        implements PermisoService {

    protected PermisoServiceImpl(
            PermisoRepository permisoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(permisoRepository, modelMapper, authValidator, PermisoResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(PermisoRequest permisoRequest) {
        return super.save(permisoRequest);
    }

    @Override
    public ListResponse<PermisoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, PermisoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public PermisoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<PermisoResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected PermisoEntity convertCreateDtoToEntity(PermisoRequest permisoRequest) {
        PermisoEntity entity = new PermisoEntity();
        entity.setInsert(permisoRequest.getInsert());
        entity.setRead(permisoRequest.getRead());
        entity.setUpdate(permisoRequest.getUpdate());
        entity.setDelete(permisoRequest.getDelete());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PermisoEntity entity, PermisoRequest dto) {
        Optional.ofNullable(dto.getInsert()).ifPresent(entity::setInsert);
        Optional.ofNullable(dto.getRead()).ifPresent(entity::setRead);
        Optional.ofNullable(dto.getUpdate()).ifPresent(entity::setUpdate);
        Optional.ofNullable(dto.getDelete()).ifPresent(entity::setDelete);
    }
}