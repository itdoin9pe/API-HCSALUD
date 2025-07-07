package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.res.AseguradoraResponse;
import com.saludsystem.principal.application.dto.req.AseguradoraRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.principal.application.service.AseguradoraService;
import com.saludsystem.principal.domain.model.AseguradoraEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.AseguradoraRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AseguradoraServiceImpl extends GenericServiceImpl<AseguradoraEntity,
        AseguradoraRequest, AseguradoraResponse, UUID> implements AseguradoraService {

    protected AseguradoraServiceImpl(
            AseguradoraRepository aseguradoraRepository, ModelMapper modelMapper,
            AuthValidator authValidator) {
        super(aseguradoraRepository, modelMapper, authValidator, AseguradoraResponse.class);
    }

    @Override
    protected AseguradoraEntity convertCreateDtoToEntity(AseguradoraRequest dto) {
        AseguradoraEntity entity = new AseguradoraEntity();
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(AseguradoraEntity entity, AseguradoraRequest dto) {
        Optional.ofNullable(dto.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }

    @Override
    public ApiResponse save(AseguradoraRequest createDto) {
        return super.save(createDto);
    }

    @Override
    public ListResponse<AseguradoraResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    public ApiResponse update(UUID uuid, AseguradoraRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<AseguradoraResponse> getList() {
        return super.getList();
    }

    @Override
    public AseguradoraResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}