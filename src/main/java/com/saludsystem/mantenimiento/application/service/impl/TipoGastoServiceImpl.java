package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.TipoGastoResponse;
import com.saludsystem.mantenimiento.application.dto.req.TipoGastoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.TipoGastoService;
import com.saludsystem.mantenimiento.domain.model.TipoGastoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoGastoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoGastoServiceImpl extends GenericServiceImpl<TipoGastoEntity, TipoGastoRequest, TipoGastoResponse, UUID>
        implements TipoGastoService {

    protected TipoGastoServiceImpl(
            TipoGastoRepository tipoGastoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoGastoRepository, modelMapper, authValidator, TipoGastoResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(TipoGastoRequest tipoGastoRequest) {
        return super.save(tipoGastoRequest);
    }

    @Override
    public ListResponse<TipoGastoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, TipoGastoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoGastoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoGastoResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoGastoEntity convertCreateDtoToEntity(TipoGastoRequest tipoGastoRequest) {
        TipoGastoEntity entity = new TipoGastoEntity();
        entity.setNombre(tipoGastoRequest.getNombre());
        entity.setEstado(tipoGastoRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoGastoEntity entity, TipoGastoRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
    }
}