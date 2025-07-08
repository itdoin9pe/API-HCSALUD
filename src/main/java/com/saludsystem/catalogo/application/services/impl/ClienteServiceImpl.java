package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.ClienteRequest;
import com.saludsystem.catalogo.application.services.ClienteService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.ClienteEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.ClienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<ClienteEntity,
        com.saludsystem.catalogo.application.dtos.req.ClienteRequest, ClienteRequest, UUID> implements ClienteService {

    protected ClienteServiceImpl(
            ClienteRepository clienteRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(clienteRepository, modelMapper, authValidator, ClienteRequest.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(com.saludsystem.catalogo.application.dtos.req.ClienteRequest clienteRequest) {
        return super.save(clienteRequest);
    }

    @Override
    public ListResponse<ClienteRequest> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, com.saludsystem.catalogo.application.dtos.req.ClienteRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    public ClienteRequest getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ClienteRequest> getList() {
        return super.getList();
    }

    @Override
    protected ClienteEntity convertCreateDtoToEntity(com.saludsystem.catalogo.application.dtos.req.ClienteRequest clienteRequest) {
        ClienteEntity entity = new ClienteEntity();
        entity.setNombre(clienteRequest.getNombre());
        entity.setContacto(clienteRequest.getContacto());
        entity.setTelefono(clienteRequest.getTelefono());
        entity.setDireccion(clienteRequest.getDireccion());
        entity.setEmail(clienteRequest.getEmail());
        entity.setTipoDocumento(clienteRequest.getTipoDocumento());
        entity.setEstado(clienteRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ClienteEntity entity, com.saludsystem.catalogo.application.dtos.req.ClienteRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getContacto()).ifPresent(entity::setContacto);
        Optional.ofNullable(dto.getTelefono()).ifPresent(entity::setTelefono);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getEmail()).ifPresent(entity::setEmail);
        Optional.ofNullable(dto.getTipoDocumento()).ifPresent(entity::setTipoDocumento);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}