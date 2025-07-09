package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.get.AseguradoraDTO;
import com.saludsystem.principal.application.dto.post.CrearAseguradoraDTO;
import com.saludsystem.principal.application.dto.put.ActualizarAseguradoraDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.principal.application.service.AseguradoraService;
import com.saludsystem.principal.domain.model.AseguradoraEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.AseguradoraRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AseguradoraServiceImpl extends GenericServiceImpl<AseguradoraEntity, AseguradoraDTO, CrearAseguradoraDTO,
        ActualizarAseguradoraDTO,UUID> implements AseguradoraService {

    protected AseguradoraServiceImpl(
            AseguradoraRepository aseguradoraRepository, ModelMapper modelMapper,
            AuthValidator authValidator) {
        super(aseguradoraRepository, modelMapper, authValidator, AseguradoraDTO.class);
    }

    @Override
    protected AseguradoraEntity convertCreateDtoToEntity(CrearAseguradoraDTO dto) {
        AseguradoraEntity entity = new AseguradoraEntity();
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(AseguradoraEntity entity, ActualizarAseguradoraDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearAseguradoraDTO createDto) {
        return super.save(createDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarAseguradoraDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}