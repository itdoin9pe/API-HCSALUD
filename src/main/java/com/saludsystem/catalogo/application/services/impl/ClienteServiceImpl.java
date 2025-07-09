package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.get.ClienteDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearClienteDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarClienteDTO;
import com.saludsystem.catalogo.application.services.ClienteService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.ClienteEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.ClienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<ClienteEntity,
        ClienteDTO, CrearClienteDTO, ActualizarClienteDTO, UUID> implements ClienteService {

    protected ClienteServiceImpl(
            ClienteRepository clienteRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(clienteRepository, modelMapper, authValidator, ClienteDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearClienteDTO clienteDTO) {
        return super.save(clienteDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarClienteDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected ClienteEntity convertCreateDtoToEntity(CrearClienteDTO clienteDTO) {
        ClienteEntity entity = new ClienteEntity();
        entity.setNombre(clienteDTO.getNombre());
        entity.setContacto(clienteDTO.getContacto());
        entity.setTelefono(clienteDTO.getTelefono());
        entity.setDireccion(clienteDTO.getDireccion());
        entity.setEmail(clienteDTO.getEmail());
        entity.setTipoDocumento(clienteDTO.getTipoDocumento());
        entity.setEstado(clienteDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ClienteEntity entity, ActualizarClienteDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getContacto()).ifPresent(entity::setContacto);
        Optional.ofNullable(dto.getTelefono()).ifPresent(entity::setTelefono);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getEmail()).ifPresent(entity::setEmail);
        Optional.ofNullable(dto.getTipoDocumento()).ifPresent(entity::setTipoDocumento);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}