package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.res.EstudioResponse;
import com.saludsystem.principal.application.dto.req.EstudioRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.principal.application.service.EstudioService;
import com.saludsystem.principal.domain.model.EstudioEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.EstudioRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstudioServiceImpl extends GenericServiceImpl<EstudioEntity, EstudioRequest, EstudioResponse, UUID>
        implements EstudioService {

    public EstudioServiceImpl(EstudioRepository estudioRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(estudioRepository, modelMapper, authValidator, EstudioResponse.class
        );
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(EstudioRequest estudioRequest) {
        return super.save(estudioRequest);
    }

    @Override
    public ListResponse<EstudioResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, EstudioRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public EstudioResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EstudioResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected EstudioEntity convertCreateDtoToEntity(EstudioRequest estudioRequest) {
        EstudioEntity entity = new EstudioEntity();
        entity.setDescripcion(estudioRequest.getDescripcion());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(EstudioEntity entity, EstudioRequest dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
    }
}