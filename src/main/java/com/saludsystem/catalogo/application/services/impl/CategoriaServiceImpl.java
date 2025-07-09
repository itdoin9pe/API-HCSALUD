package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.get.CategoriaDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearCategoriaDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarCategoriaDTO;
import com.saludsystem.catalogo.application.services.CategoriaService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.CategoriaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.CategoriaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaServiceImpl extends GenericServiceImpl<CategoriaEntity,
        CategoriaDTO, CrearCategoriaDTO, ActualizarCategoriaDTO, UUID> implements CategoriaService {

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ModelMapper modelMapper,
                                AuthValidator authValidator) {
        super(categoriaRepository, modelMapper, authValidator, CategoriaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearCategoriaDTO dto) {
        return save(dto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarCategoriaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    protected CategoriaEntity convertCreateDtoToEntity(CrearCategoriaDTO categoriaDTO) {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setNombre(categoriaDTO.getNombre());
        entity.setEstado(categoriaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CategoriaEntity entity, ActualizarCategoriaDTO dto) {
        Optional.ofNullable(dto.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}