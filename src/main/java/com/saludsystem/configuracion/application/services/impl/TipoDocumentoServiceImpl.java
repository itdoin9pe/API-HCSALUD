package com.saludsystem.configuracion.application.services.impl;

import com.saludsystem.configuracion.application.dto.res.TipoDocumentoResponse;
import com.saludsystem.configuracion.application.dto.req.TipoDocumentoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.configuracion.application.services.TipoDocumentoService;
import com.saludsystem.configuracion.domain.model.TipoDocumentoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.TipoDocumentoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoDocumentoServiceImpl extends GenericServiceImpl<TipoDocumentoEntity, TipoDocumentoRequest,
        TipoDocumentoResponse, UUID> implements TipoDocumentoService {

    protected TipoDocumentoServiceImpl(
            TipoDocumentoRepository tipoDocumentoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoDocumentoRepository, modelMapper, authValidator, TipoDocumentoResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(TipoDocumentoRequest tipoDocumentoRequest) {
        return super.save(tipoDocumentoRequest);
    }

    @Override
    public ListResponse<TipoDocumentoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, TipoDocumentoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoDocumentoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoDocumentoResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoDocumentoEntity convertCreateDtoToEntity(TipoDocumentoRequest tipoDocumentoRequest) {
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.setTipoComprobante(tipoDocumentoRequest.getTipoComprobante());
        entity.setSerie(tipoDocumentoRequest.getSerie());
        entity.setInicio(tipoDocumentoRequest.getInicio());
        entity.setFin(tipoDocumentoRequest.getFin());
        entity.setCorrelativoActual(tipoDocumentoRequest.getCorrelativoActual());
        entity.setEstado(tipoDocumentoRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoDocumentoEntity entity, TipoDocumentoRequest dto) {
        Optional.ofNullable(dto.getTipoComprobante()).ifPresent(entity::setTipoComprobante);
        Optional.ofNullable(dto.getSerie()).ifPresent(entity::setSerie);
        Optional.ofNullable(dto.getInicio()).ifPresent(entity::setInicio);
        Optional.ofNullable(dto.getFin()).ifPresent(entity::setFin);
        Optional.ofNullable(dto.getCorrelativoActual()).ifPresent(entity::setCorrelativoActual);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}