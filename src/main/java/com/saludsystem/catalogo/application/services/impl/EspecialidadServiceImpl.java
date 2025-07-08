package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.EspecialidadRequest;
import com.saludsystem.catalogo.application.services.EspecialidadService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.EspecialidadEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.EspecialidadRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EspecialidadServiceImpl extends GenericServiceImpl<EspecialidadEntity, com.saludsystem.catalogo.application.dtos.req.EspecialidadRequest,
        EspecialidadRequest, UUID> implements EspecialidadService {

    protected EspecialidadServiceImpl(
            EspecialidadRepository especialidadRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(especialidadRepository, modelMapper, authValidator, EspecialidadRequest.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(com.saludsystem.catalogo.application.dtos.req.EspecialidadRequest especialidadRequest) {
        return super.save(especialidadRequest);
    }

    @Override
    public ListResponse<EspecialidadRequest> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, com.saludsystem.catalogo.application.dtos.req.EspecialidadRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    public EspecialidadRequest getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EspecialidadRequest> getList() {
        return super.getList();
    }

    @Override
    protected EspecialidadEntity convertCreateDtoToEntity(com.saludsystem.catalogo.application.dtos.req.EspecialidadRequest especialidadRequest) {
        EspecialidadEntity entity = new EspecialidadEntity();
        entity.setNombre(especialidadRequest.getNombre());
        entity.setDescripcion(especialidadRequest.getDescripcion());
        entity.setEstado(especialidadRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(EspecialidadEntity entity, com.saludsystem.catalogo.application.dtos.req.EspecialidadRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}