package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.get.TipoPagoDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTipoPagoDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTipoPagoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.TipoPagoService;
import com.saludsystem.mantenimiento.domain.model.TipoPagoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoPagoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TipoPagoServiceImpl extends GenericServiceImpl<TipoPagoEntity, TipoPagoDTO, CrearTipoPagoDTO,
        ActualizarTipoPagoDTO, UUID> implements TipoPagoService {

    protected TipoPagoServiceImpl(
            TipoPagoRepository tipoPagoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoPagoRepository, modelMapper, authValidator, TipoPagoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoPagoDTO crearTipoPagoDTO) {
        return super.save(crearTipoPagoDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoPagoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoPagoEntity convertCreateDtoToEntity(CrearTipoPagoDTO crearTipoPagoDTO) {
        TipoPagoEntity entity = new TipoPagoEntity();
        entity.setDescripcion(crearTipoPagoDTO.getDescripcion());
        entity.setMetodoPago(crearTipoPagoDTO.getMetodoPago());
        entity.setEstado(crearTipoPagoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoPagoEntity entity, ActualizarTipoPagoDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getMetodoPago()).ifPresent(entity::setMetodoPago);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}