package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.BancoResponse;
import com.saludsystem.mantenimiento.application.dto.req.BancoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.BancoService;
import com.saludsystem.mantenimiento.domain.model.BancoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.BancoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BancoServiceImpl extends GenericServiceImpl<BancoEntity, BancoRequest, BancoResponse, UUID>
        implements BancoService {

    protected BancoServiceImpl(BancoRepository bancoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(bancoRepository, modelMapper, authValidator, BancoResponse.class);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(BancoRequest bancoRequest) {
        return super.save(bancoRequest);
    }

    @Override
    public ListResponse<BancoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, BancoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<BancoResponse> getList() {
        return super.getList();
    }

    @Override
    public BancoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected BancoEntity convertCreateDtoToEntity(BancoRequest bancoRequest) {
        BancoEntity entity = new BancoEntity();
        entity.setDescripcion(bancoRequest.getDescripcion());
        entity.setEstado(bancoRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(BancoEntity entity, BancoRequest dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}