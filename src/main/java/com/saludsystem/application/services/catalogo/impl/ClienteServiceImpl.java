package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.get.ClienteDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearClienteDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarClienteDTO;
import com.saludsystem.application.services.catalogo.ClienteService;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.domain.model.catalogo.ClienteEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.ClienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<ClienteEntity, ClienteDTO, UUID,
        CrearClienteDTO, ActualizarClienteDTO> implements ClienteService {

    public ClienteServiceImpl(ClienteRepository clienteRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(clienteRepository, modelMapper, authValidator, ClienteDTO.class,
                clienteEntity -> modelMapper.map(clienteEntity, ClienteDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearClienteDTO crearClienteDTO) {
        return super.save(crearClienteDTO);
    }

    @Override
    public ListResponse<ClienteDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarClienteDTO actualizarClienteDTO) {
        return super.update(uuid, actualizarClienteDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    public ClienteDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ClienteDTO> getList() {
        return super.getList();
    }

    @Override
    protected ClienteEntity convertCreateDtoToEntity(CrearClienteDTO crearClienteDTO) {
        ClienteEntity entity = new ClienteEntity();
        entity.setNombre(crearClienteDTO.getNombre());
        entity.setContacto(crearClienteDTO.getContacto());
        entity.setTelefono(crearClienteDTO.getTelefono());
        entity.setDireccion(crearClienteDTO.getDireccion());
        entity.setEmail(crearClienteDTO.getEmail());
        entity.setTipoDocumento(crearClienteDTO.getTipoDocumento());
        entity.setEstado(crearClienteDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarClienteDTO actualizarClienteDTO, ClienteEntity entity) {
        entity.setNombre(actualizarClienteDTO.getNombre());
        entity.setContacto(actualizarClienteDTO.getContacto());
        entity.setTelefono(actualizarClienteDTO.getTelefono());
        entity.setDireccion(actualizarClienteDTO.getDireccion());
        entity.setEmail(actualizarClienteDTO.getEmail());
        entity.setTipoDocumento(actualizarClienteDTO.getTipoDocumento());
        entity.setEstado(actualizarClienteDTO.getEstado());
    }
}