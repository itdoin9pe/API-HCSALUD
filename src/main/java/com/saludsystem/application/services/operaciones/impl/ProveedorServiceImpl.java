package com.saludsystem.application.services.operaciones.impl;

import com.saludsystem.application.dtos.operaciones.get.ProveedorDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearProveedorDTO;
import com.saludsystem.application.dtos.operaciones.put.ActualizarProveedorDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.operaciones.ProveedorService;
import com.saludsystem.domain.model.operaciones.ProveedorEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.operaciones.ProveedorRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<ProveedorEntity, ProveedorDTO, UUID,
        CrearProveedorDTO, ActualizarProveedorDTO> implements ProveedorService {

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(proveedorRepository, modelMapper, authValidator, ProveedorDTO.class,
                proveedorEntity -> modelMapper.map(proveedorEntity, ProveedorDTO.class));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearProveedorDTO crearProveedorDTO) {
        return super.save(crearProveedorDTO);
    }

    @Override
    public ListResponse<ProveedorDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarProveedorDTO actualizarProveedorDTO) {
        return super.update(uuid, actualizarProveedorDTO);
    }

    @Override
    public ProveedorDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ProveedorDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected ProveedorEntity convertCreateDtoToEntity(CrearProveedorDTO crearProveedorDTO) {
        ProveedorEntity entity = new ProveedorEntity();
        entity.setNombre(crearProveedorDTO.getNombre());
        entity.setContacto(crearProveedorDTO.getContacto());
        entity.setCorreo(crearProveedorDTO.getCorreo());
        entity.setDireccion(crearProveedorDTO.getDireccion());
        entity.setRuc(crearProveedorDTO.getRuc());
        entity.setTelefono(crearProveedorDTO.getTelefono());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarProveedorDTO actualizarProveedorDTO, ProveedorEntity entity) {
        entity.setNombre(actualizarProveedorDTO.getNombre());
        entity.setContacto(actualizarProveedorDTO.getContacto());
        entity.setCorreo(actualizarProveedorDTO.getCorreo());
        entity.setDireccion(actualizarProveedorDTO.getDireccion());
        entity.setRuc(actualizarProveedorDTO.getRuc());
        entity.setTelefono(actualizarProveedorDTO.getTelefono());
    }
}