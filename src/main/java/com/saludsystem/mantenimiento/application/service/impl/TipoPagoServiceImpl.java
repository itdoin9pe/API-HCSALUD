package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.TipoPagoResponse;
import com.saludsystem.mantenimiento.application.dto.req.TipoPagoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.TipoPagoService;
import com.saludsystem.mantenimiento.domain.model.TipoPagoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoPagoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoPagoServiceImpl extends GenericServiceImpl<TipoPagoEntity, TipoPagoRequest, TipoPagoResponse, UUID>
        implements TipoPagoService {

    protected TipoPagoServiceImpl(
            TipoPagoRepository tipoPagoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoPagoRepository, modelMapper, authValidator, TipoPagoResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(TipoPagoRequest tipoPagoRequest) {
        return super.save(tipoPagoRequest);
    }

    @Override
    public ListResponse<TipoPagoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, TipoPagoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoPagoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoPagoResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoPagoEntity convertCreateDtoToEntity(TipoPagoRequest tipoPagoRequest) {
        TipoPagoEntity entity = new TipoPagoEntity();
        entity.setDescripcion(tipoPagoRequest.getDescripcion());
        entity.setMetodoPago(tipoPagoRequest.getMetodoPago());
        entity.setEstado(tipoPagoRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoPagoEntity entity, TipoPagoRequest dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getMetodoPago()).ifPresent(entity::setMetodoPago);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}