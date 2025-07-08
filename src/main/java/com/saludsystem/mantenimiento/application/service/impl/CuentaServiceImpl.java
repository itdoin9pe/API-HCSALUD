package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.CuentaResponse;
import com.saludsystem.mantenimiento.application.dto.req.CuentaRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.CuentaService;
import com.saludsystem.mantenimiento.domain.model.CuentaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.CuentaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuentaServiceImpl extends GenericServiceImpl<CuentaEntity, CuentaRequest, CuentaResponse, UUID>
        implements CuentaService {

    protected CuentaServiceImpl(
            CuentaRepository cuentaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(cuentaRepository, modelMapper, authValidator, CuentaResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CuentaRequest cuentaRequest) {
        return super.save(cuentaRequest);
    }

    @Override
    public ListResponse<CuentaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CuentaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public CuentaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CuentaResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected CuentaEntity convertCreateDtoToEntity(CuentaRequest cuentaRequest) {
        CuentaEntity entity = new CuentaEntity();
        entity.setNombre(cuentaRequest.getNombre());
        entity.setTotal(cuentaRequest.getTotal());
        entity.setEstado(cuentaRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CuentaEntity entity, CuentaRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getTotal()).ifPresent(entity::setTotal);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}