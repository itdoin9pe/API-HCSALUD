package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.get.TipoCitadoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearTipoCitadoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarTipoCitadoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.application.services.TipoCitadoService;
import com.saludsystem.catalogo.domain.model.TipoCitadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.TipoCitadoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TipoCitadoServiceImpl extends GenericServiceImpl<TipoCitadoEntity, TipoCitadoDTO,
        CrearTipoCitadoDTO, ActualizarTipoCitadoDTO, UUID> implements TipoCitadoService {

    protected TipoCitadoServiceImpl(
            TipoCitadoRepository tipoCitadoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoCitadoRepository, modelMapper, authValidator, TipoCitadoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoCitadoDTO tipoCitadoDTO) {
        return super.save(tipoCitadoDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoCitadoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoCitadoEntity convertCreateDtoToEntity(CrearTipoCitadoDTO tipoCitadoDTO) {
        TipoCitadoEntity entity = new TipoCitadoEntity();
        entity.setNombre(tipoCitadoDTO.getNombre());
        entity.setColor(tipoCitadoDTO.getColor());
        entity.setEstado(tipoCitadoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoCitadoEntity entity, ActualizarTipoCitadoDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getColor()).ifPresent(entity::setColor);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}