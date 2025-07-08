package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.res.EmpresaResponse;
import com.saludsystem.principal.application.dto.req.EmpresaRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.principal.application.service.EmpresaService;
import com.saludsystem.principal.domain.model.EmpresaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.EmpresaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpresaServiceImpl extends GenericServiceImpl<EmpresaEntity, EmpresaRequest, EmpresaResponse, UUID>
        implements EmpresaService {

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(empresaRepository, modelMapper, authValidator, EmpresaResponse.class
        );
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(EmpresaRequest empresaRequest) {
        return super.save(empresaRequest);
    }

    @Override
    public ListResponse<EmpresaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, EmpresaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public EmpresaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EmpresaResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected EmpresaEntity convertCreateDtoToEntity(EmpresaRequest empresaRequest) {
        EmpresaEntity entity = new EmpresaEntity();
        entity.setDescripcion(empresaRequest.getDescripcion());
        entity.setEstado(empresaRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(EmpresaEntity entity, EmpresaRequest dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}