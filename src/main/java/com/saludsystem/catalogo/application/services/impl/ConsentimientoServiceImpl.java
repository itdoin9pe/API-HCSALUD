package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.ConsentimientoRequest;
import com.saludsystem.catalogo.application.services.ConsentimientoService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.ConsentimientoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.ConsentimientoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsentimientoServiceImpl extends GenericServiceImpl<ConsentimientoEntity, com.saludsystem.catalogo.application.dtos.req.ConsentimientoRequest,
        ConsentimientoRequest, UUID> implements ConsentimientoService {

    protected ConsentimientoServiceImpl(
            ConsentimientoRepository consentimientoRepository,
            ModelMapper modelMapper, AuthValidator authValidator) {
        super(consentimientoRepository, modelMapper, authValidator, ConsentimientoRequest.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(com.saludsystem.catalogo.application.dtos.req.ConsentimientoRequest consentimientoRequest) {
        return super.save(consentimientoRequest);
    }

    @Override
    public ListResponse<ConsentimientoRequest> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, com.saludsystem.catalogo.application.dtos.req.ConsentimientoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    public ConsentimientoRequest getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ConsentimientoRequest> getList() {
        return super.getList();
    }

    @Override
    protected ConsentimientoEntity convertCreateDtoToEntity(com.saludsystem.catalogo.application.dtos.req.ConsentimientoRequest consentimientoRequest) {
        ConsentimientoEntity entity = new ConsentimientoEntity();
        entity.setNombre(consentimientoRequest.getNombre());
        entity.setObservacion(consentimientoRequest.getObservacion());
        entity.setTexto(consentimientoRequest.getTexto());
        entity.setEstado(consentimientoRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ConsentimientoEntity entity, com.saludsystem.catalogo.application.dtos.req.ConsentimientoRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getObservacion()).ifPresent(entity::setObservacion);
        Optional.ofNullable(dto.getTexto()).ifPresent(entity::setTexto);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}