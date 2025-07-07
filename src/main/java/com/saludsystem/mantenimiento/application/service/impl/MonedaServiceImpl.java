package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.MonedaDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearMonedaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.MonedaService;
import com.saludsystem.mantenimiento.domain.model.MonedaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.MonedaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MonedaServiceImpl extends GenericServiceImpl<MonedaEntity, CrearMonedaDTO, MonedaDTO, UUID>
        implements MonedaService {

    protected MonedaServiceImpl(
            MonedaRepository monedaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(monedaRepository, modelMapper, authValidator, MonedaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearMonedaDTO crearMonedaDTO) {
        return super.save(crearMonedaDTO);
    }

    @Override
    public ListResponse<MonedaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearMonedaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<MonedaDTO> getList() {
        return super.getList();
    }

    @Override
    public MonedaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected MonedaEntity convertCreateDtoToEntity(CrearMonedaDTO crearMonedaDTO) {
        MonedaEntity entity = new MonedaEntity();
        entity.setDescripcion(crearMonedaDTO.getDescripcion());
        entity.setEstado(crearMonedaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(MonedaEntity entity, CrearMonedaDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}