package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.get.PresentacionDTO;
import com.saludsystem.operaciones.application.dto.post.CrearPresentacionDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarPresentacionDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.PresentacionService;
import com.saludsystem.operaciones.domain.model.PresentacionEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.PresentacionReposirory;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PresentacionServiceImpl extends GenericServiceImpl<PresentacionEntity, PresentacionDTO,
        CrearPresentacionDTO, ActualizarPresentacionDTO, UUID> implements PresentacionService {

    public PresentacionServiceImpl(
            PresentacionReposirory presentacionReposirory, ModelMapper modelMapper, AuthValidator authValidator) {
        super(presentacionReposirory, modelMapper, authValidator, PresentacionDTO.class
        );
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPresentacionDTO crearPresentacionDTO) {
        return super.save(crearPresentacionDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarPresentacionDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected PresentacionEntity convertCreateDtoToEntity(CrearPresentacionDTO crearPresentacionDTO) {
        PresentacionEntity entity = new PresentacionEntity();
        entity.setNombre(crearPresentacionDTO.getNombre());
        entity.setEstado(crearPresentacionDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PresentacionEntity entity, ActualizarPresentacionDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}