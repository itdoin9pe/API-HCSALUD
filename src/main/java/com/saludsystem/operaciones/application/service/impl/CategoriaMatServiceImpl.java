package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.res.CategoriaMatResponse;
import com.saludsystem.operaciones.application.dto.req.CategotiaMatRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.CategoriaMatService;
import com.saludsystem.operaciones.domain.model.CategoriaMatEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.CategoriaMatRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaMatServiceImpl extends GenericServiceImpl<CategoriaMatEntity, CategotiaMatRequest,
        CategoriaMatResponse, UUID> implements CategoriaMatService {

    protected CategoriaMatServiceImpl(
            CategoriaMatRepository categoriaMatRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(categoriaMatRepository, modelMapper, authValidator, CategoriaMatResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CategotiaMatRequest categotiaMatRequest) {
        return super.save(categotiaMatRequest);
    }

    @Override
    public ListResponse<CategoriaMatResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CategotiaMatRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public CategoriaMatResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CategoriaMatResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected CategoriaMatEntity convertCreateDtoToEntity(CategotiaMatRequest categotiaMatRequest) {
        CategoriaMatEntity entity = new CategoriaMatEntity();
        entity.setNombre(categotiaMatRequest.getNombre());
        entity.setDescripcion(categotiaMatRequest.getDescripcion());
        entity.setEstado(categotiaMatRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CategoriaMatEntity entity, CategotiaMatRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}