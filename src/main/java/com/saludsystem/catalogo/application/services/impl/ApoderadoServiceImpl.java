package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.get.ApoderadoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearApoderadoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarApoderadoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.application.services.ApoderadoService;
import com.saludsystem.catalogo.domain.model.ApoderadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.ApoderadoRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ApoderadoServiceImpl extends GenericServiceImpl<ApoderadoEntity, ApoderadoDTO,
        CrearApoderadoDTO, ActualizarApoderadoDTO, UUID> implements ApoderadoService {


    public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository, ModelMapper modelMapper,
            AuthValidator authValidator) {
        super(apoderadoRepository, modelMapper, authValidator, ApoderadoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearApoderadoDTO dto) {
        return super.save(dto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarApoderadoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    protected ApoderadoEntity convertCreateDtoToEntity(CrearApoderadoDTO apoderadoDTO) {
        ApoderadoEntity entity = new ApoderadoEntity();
        entity.setNombre(apoderadoDTO.getNombre());
        entity.setNroDocumento(apoderadoDTO.getNroDocumento());
        entity.setDireccion(apoderadoDTO.getDireccion());
        entity.setTelefono(apoderadoDTO.getTelefono());
        entity.setEstado(apoderadoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ApoderadoEntity entity, ActualizarApoderadoDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getNroDocumento()).ifPresent(entity::setNroDocumento);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getTelefono()).ifPresent(entity::setTelefono);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}