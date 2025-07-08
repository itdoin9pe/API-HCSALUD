package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.MedidaRequest;
import com.saludsystem.catalogo.application.services.MedidaService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.MedidaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.MedidaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedidaServiceImpl extends GenericServiceImpl<MedidaEntity, com.saludsystem.catalogo.application.dtos.req.MedidaRequest, MedidaRequest, UUID>
        implements MedidaService {


    protected MedidaServiceImpl(MedidaRepository medidaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(medidaRepository, modelMapper, authValidator, MedidaRequest.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(com.saludsystem.catalogo.application.dtos.req.MedidaRequest medidaRequest) {
        return super.save(medidaRequest);
    }

    @Override
    public ListResponse<MedidaRequest> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, com.saludsystem.catalogo.application.dtos.req.MedidaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public MedidaRequest getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<MedidaRequest> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected MedidaEntity convertCreateDtoToEntity(com.saludsystem.catalogo.application.dtos.req.MedidaRequest medidaRequest) {
        MedidaEntity entity = new MedidaEntity();
        entity.setNombre(medidaRequest.getNombre());
        entity.setEstado(medidaRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(MedidaEntity entity, com.saludsystem.catalogo.application.dtos.req.MedidaRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}