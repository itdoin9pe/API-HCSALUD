package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.get.CuentaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearCuentaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarCuentaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.CuentaService;
import com.saludsystem.mantenimiento.domain.model.CuentaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.CuentaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CuentaServiceImpl extends GenericServiceImpl<CuentaEntity, CuentaDTO, CrearCuentaDTO,
        ActualizarCuentaDTO, UUID> implements CuentaService {

    protected CuentaServiceImpl(
            CuentaRepository cuentaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(cuentaRepository, modelMapper, authValidator, CuentaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearCuentaDTO crearCuentaDTO) {
        return super.save(crearCuentaDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarCuentaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected CuentaEntity convertCreateDtoToEntity(CrearCuentaDTO crearCuentaDTO) {
        CuentaEntity entity = new CuentaEntity();
        entity.setNombre(crearCuentaDTO.getNombre());
        entity.setTotal(crearCuentaDTO.getTotal());
        entity.setEstado(crearCuentaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CuentaEntity entity, ActualizarCuentaDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getTotal()).ifPresent(entity::setTotal);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}