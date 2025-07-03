package com.saludsystem.application.services.mantenimiento.impl;


import com.saludsystem.application.dtos.mantenimiento.get.MonedaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearMonedaDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarMonedaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.mantenimiento.MonedaService;
import com.saludsystem.domain.model.mantenimiento.MonedaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.MonedaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MonedaServiceImpl extends GenericServiceImpl<MonedaEntity, MonedaDTO,
        UUID, CrearMonedaDTO, ActualizarMonedaDTO> implements MonedaService {

    public MonedaServiceImpl(MonedaRepository monedaRepository, AuthValidator authValidator, ModelMapper modelMapper) {
        super(monedaRepository, modelMapper, authValidator, MonedaDTO.class,
                monedaEntity -> modelMapper.map(monedaEntity, MonedaDTO.class));
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
    public ApiResponse update(UUID uuid, ActualizarMonedaDTO actualizarMonedaDTO) {
        return super.update(uuid, actualizarMonedaDTO);
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
    protected void updateEntityFromDto(ActualizarMonedaDTO actualizarMonedaDTO, MonedaEntity entity) {
        entity.setDescripcion(actualizarMonedaDTO.getDescripcion());
        entity.setEstado(actualizarMonedaDTO.getEstado());
    }
}