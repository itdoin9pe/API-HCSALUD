package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.res.UnidadResponse;
import com.saludsystem.operaciones.application.dto.req.UnidadRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.UnidadService;
import com.saludsystem.operaciones.domain.model.UnidadEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.UnidadRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UnidadServiceImpl extends GenericServiceImpl<UnidadEntity, UnidadRequest, UnidadResponse, UUID>
        implements UnidadService {

    public UnidadServiceImpl(UnidadRepository unidadRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(unidadRepository, modelMapper, authValidator, UnidadResponse.class
        );
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(UnidadRequest unidadRequest) {
        return super.save(unidadRequest);
    }

    @Override
    public ListResponse<UnidadResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, UnidadRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<UnidadResponse> getList() {
        return super.getList();
    }

    @Override
    public UnidadResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected UnidadEntity convertCreateDtoToEntity(UnidadRequest unidadRequest) {
        UnidadEntity entity = new UnidadEntity();
        entity.setNombre(unidadRequest.getNombre());
        entity.setSiglas(unidadRequest.getSiglas());
        entity.setDescripcion(unidadRequest.getDescripcion());
        entity.setEstado(unidadRequest.getEstado());
        return null;
    }

    @Override
    protected void updateEntityFromDto(UnidadEntity entity, UnidadRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getSiglas()).ifPresent(entity::setSiglas);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}