package com.saludsystem.operaciones.application.service.impl;

import com.saludsystem.operaciones.application.dto.get.UnidadDTO;
import com.saludsystem.operaciones.application.dto.post.CrearUnidadDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarUnidadDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.operaciones.application.service.UnidadService;
import com.saludsystem.operaciones.domain.model.UnidadEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.UnidadRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UnidadServiceImpl extends GenericServiceImpl<UnidadEntity, UnidadDTO, CrearUnidadDTO,
        ActualizarUnidadDTO, UUID> implements UnidadService {

    public UnidadServiceImpl(UnidadRepository unidadRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(unidadRepository, modelMapper, authValidator, UnidadDTO.class
        );
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearUnidadDTO crearUnidadDTO) {
        return super.save(crearUnidadDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarUnidadDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected UnidadEntity convertCreateDtoToEntity(CrearUnidadDTO crearUnidadDTO) {
        UnidadEntity entity = new UnidadEntity();
        entity.setNombre(crearUnidadDTO.getNombre());
        entity.setSiglas(crearUnidadDTO.getSiglas());
        entity.setDescripcion(crearUnidadDTO.getDescripcion());
        entity.setEstado(crearUnidadDTO.getEstado());
        return null;
    }

    @Override
    protected void updateEntityFromDto(UnidadEntity entity, ActualizarUnidadDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getSiglas()).ifPresent(entity::setSiglas);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}