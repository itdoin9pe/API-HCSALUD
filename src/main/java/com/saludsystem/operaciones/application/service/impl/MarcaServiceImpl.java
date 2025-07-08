package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.res.MarcaResponse;
import com.saludsystem.operaciones.application.dto.req.MarcaRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.MarcaService;
import com.saludsystem.operaciones.domain.model.MarcaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.MarcaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MarcaServiceImpl extends GenericServiceImpl<MarcaEntity, MarcaRequest, MarcaResponse, UUID>
        implements MarcaService {

    protected MarcaServiceImpl(MarcaRepository marcaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(marcaRepository, modelMapper, authValidator, MarcaResponse.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(MarcaRequest marcaRequest) {
        return super.save(marcaRequest);
    }

    @Override
    public ListResponse<MarcaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, MarcaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<MarcaResponse> getList() {
        return super.getList();
    }

    @Override
    public MarcaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected MarcaEntity convertCreateDtoToEntity(MarcaRequest marcaRequest) {
        MarcaEntity entity = new MarcaEntity();
        entity.setNombre(marcaRequest.getNombre());
        entity.setEstado(marcaRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(MarcaEntity entity, MarcaRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}