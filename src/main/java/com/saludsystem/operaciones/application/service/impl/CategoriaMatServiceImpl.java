package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.get.CategoriaMatDTO;
import com.saludsystem.operaciones.application.dto.post.CrearCategotiaMatDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarCategoriaMatDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.CategoriaMatService;
import com.saludsystem.operaciones.domain.model.CategoriaMatEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.CategoriaMatRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaMatServiceImpl extends GenericServiceImpl<CategoriaMatEntity, CategoriaMatDTO,
        CrearCategotiaMatDTO, ActualizarCategoriaMatDTO, UUID> implements CategoriaMatService {

    protected CategoriaMatServiceImpl(
            CategoriaMatRepository categoriaMatRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(categoriaMatRepository, modelMapper, authValidator, CategoriaMatDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearCategotiaMatDTO crearCategotiaMatDTO) {
        return super.save(crearCategotiaMatDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarCategoriaMatDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected CategoriaMatEntity convertCreateDtoToEntity(CrearCategotiaMatDTO crearCategotiaMatDTO) {
        CategoriaMatEntity entity = new CategoriaMatEntity();
        entity.setNombre(crearCategotiaMatDTO.getNombre());
        entity.setDescripcion(crearCategotiaMatDTO.getDescripcion());
        entity.setEstado(crearCategotiaMatDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CategoriaMatEntity entity, ActualizarCategoriaMatDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}