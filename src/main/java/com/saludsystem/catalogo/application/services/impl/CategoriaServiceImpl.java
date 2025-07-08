package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.CategoriaRequest;
import com.saludsystem.catalogo.application.services.CategoriaService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.CategoriaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.CategoriaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaServiceImpl extends GenericServiceImpl<CategoriaEntity,
        com.saludsystem.catalogo.application.dtos.req.CategoriaRequest, CategoriaRequest, UUID> implements CategoriaService {

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ModelMapper modelMapper,
                                AuthValidator authValidator) {
        super(categoriaRepository, modelMapper, authValidator, CategoriaRequest.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(com.saludsystem.catalogo.application.dtos.req.CategoriaRequest dto) {
        return save(dto);
    }

    @Override
    public ListResponse<CategoriaRequest> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, com.saludsystem.catalogo.application.dtos.req.CategoriaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    public CategoriaRequest getById(UUID id) {
        return super.getById(id);
    }

    @Override
    protected CategoriaEntity convertCreateDtoToEntity(com.saludsystem.catalogo.application.dtos.req.CategoriaRequest categoriaRequest) {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setNombre(categoriaRequest.getNombre());
        entity.setEstado(categoriaRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CategoriaEntity entity, com.saludsystem.catalogo.application.dtos.req.CategoriaRequest dto) {
        Optional.ofNullable(dto.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}