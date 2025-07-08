package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.ApoderadoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.application.services.ApoderadoService;
import com.saludsystem.catalogo.domain.model.ApoderadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.ApoderadoRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApoderadoServiceImpl extends GenericServiceImpl<ApoderadoEntity, com.saludsystem.catalogo.application.dtos.req.ApoderadoRequest,
        ApoderadoRequest, UUID> implements ApoderadoService {

    private final SysSaludRepository sysSaludRepository;

    public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, SysSaludRepository sysSaludRepository) {
        super(apoderadoRepository, modelMapper, authValidator, ApoderadoRequest.class);
        this.sysSaludRepository = sysSaludRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(com.saludsystem.catalogo.application.dtos.req.ApoderadoRequest dto) {
        return super.save(dto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, com.saludsystem.catalogo.application.dtos.req.ApoderadoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    public ApoderadoRequest getById(UUID id) {
        return super.getById(id);
    }

    @Override
    public List<ApoderadoRequest> getList() {
        return super.getList();
    }
    
    @Override
    public ListResponse<ApoderadoRequest> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    protected ApoderadoEntity convertCreateDtoToEntity(com.saludsystem.catalogo.application.dtos.req.ApoderadoRequest apoderadoRequest) {
        ApoderadoEntity entity = new ApoderadoEntity();
        entity.setNombre(apoderadoRequest.getNombre());
        entity.setNroDocumento(apoderadoRequest.getNroDocumento());
        entity.setDireccion(apoderadoRequest.getDireccion());
        entity.setTelefono(apoderadoRequest.getTelefono());
        entity.setEstado(apoderadoRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ApoderadoEntity entity, com.saludsystem.catalogo.application.dtos.req.ApoderadoRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getNroDocumento()).ifPresent(entity::setNroDocumento);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getTelefono()).ifPresent(entity::setTelefono);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}