package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.TipoTarjetaResponse;
import com.saludsystem.mantenimiento.application.dto.req.TipoTarjetaRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.TipoTarjetaService;
import com.saludsystem.mantenimiento.domain.model.TipoTarjetaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoTarjetaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoTarjetaServiceImpl extends GenericServiceImpl<TipoTarjetaEntity, TipoTarjetaRequest, TipoTarjetaResponse,
        UUID> implements TipoTarjetaService {

    protected TipoTarjetaServiceImpl(
            TipoTarjetaRepository tipoTarjetaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoTarjetaRepository, modelMapper, authValidator, TipoTarjetaResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(TipoTarjetaRequest tipoTarjetaRequest) {
        return super.save(tipoTarjetaRequest);
    }

    @Override
    public ListResponse<TipoTarjetaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, TipoTarjetaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoTarjetaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoTarjetaResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoTarjetaEntity convertCreateDtoToEntity(TipoTarjetaRequest tipoTarjetaRequest) {
        TipoTarjetaEntity entity = new TipoTarjetaEntity();
        entity.setDescripcion(tipoTarjetaRequest.getDescripcion());
        entity.setEstado(tipoTarjetaRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoTarjetaEntity entity, TipoTarjetaRequest dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}