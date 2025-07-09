package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.get.ProveedorDTO;
import com.saludsystem.operaciones.application.dto.post.CrearProveedorDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarProveedorDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.ProveedorService;
import com.saludsystem.operaciones.domain.model.ProveedorEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProveedorRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<ProveedorEntity,ProveedorDTO, CrearProveedorDTO,
        ActualizarProveedorDTO, UUID> implements ProveedorService {

    public ProveedorServiceImpl(
            ProveedorRepository proveedorRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(proveedorRepository, modelMapper, authValidator, ProveedorDTO.class);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearProveedorDTO crearProveedorDTO) {
        return super.save(crearProveedorDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarProveedorDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(ProveedorEntity entity, ActualizarProveedorDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getContacto()).ifPresent(entity::setContacto);
        Optional.ofNullable(dto.getCorreo()).ifPresent(entity::setCorreo);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getRuc()).ifPresent(entity::setRuc);
        Optional.ofNullable(dto.getTelefono()).ifPresent(entity::setTelefono);
    }
}