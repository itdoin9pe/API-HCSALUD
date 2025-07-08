package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.res.ProveedorResponse;
import com.saludsystem.operaciones.application.dto.req.ProveedorRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.ProveedorService;
import com.saludsystem.operaciones.domain.model.ProveedorEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProveedorRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<ProveedorEntity, ProveedorRequest, ProveedorResponse, UUID>
        implements ProveedorService {

    public ProveedorServiceImpl(
            ProveedorRepository proveedorRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(proveedorRepository, modelMapper, authValidator, ProveedorResponse.class);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(ProveedorRequest proveedorRequest) {
        return super.save(proveedorRequest);
    }

    @Override
    public ListResponse<ProveedorResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ProveedorRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public ProveedorResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ProveedorResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected ProveedorEntity convertCreateDtoToEntity(ProveedorRequest proveedorRequest) {
        ProveedorEntity entity = new ProveedorEntity();
        entity.setNombre(proveedorRequest.getNombre());
        entity.setContacto(proveedorRequest.getContacto());
        entity.setCorreo(proveedorRequest.getCorreo());
        entity.setDireccion(proveedorRequest.getDireccion());
        entity.setRuc(proveedorRequest.getRuc());
        entity.setTelefono(proveedorRequest.getTelefono());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ProveedorEntity entity, ProveedorRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getContacto()).ifPresent(entity::setContacto);
        Optional.ofNullable(dto.getCorreo()).ifPresent(entity::setCorreo);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getRuc()).ifPresent(entity::setRuc);
        Optional.ofNullable(dto.getTelefono()).ifPresent(entity::setTelefono);
    }
}