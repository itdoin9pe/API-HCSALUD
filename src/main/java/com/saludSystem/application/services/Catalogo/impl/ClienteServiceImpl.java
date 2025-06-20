package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.GET.ClienteDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearClienteDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarClienteDTO;
import com.saludSystem.application.services.Catalogo.ClienteService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Catalogo.ClienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.ClienteRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

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