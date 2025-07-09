package com.saludsystem.configuracion.application.services.impl;

import com.saludsystem.configuracion.application.dto.get.TipoDocumentoDTO;
import com.saludsystem.configuracion.application.dto.post.CrearTipoDocumentoDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarTipoDocumentoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.configuracion.application.services.TipoDocumentoService;
import com.saludsystem.configuracion.domain.model.TipoDocumentoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.TipoDocumentoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TipoDocumentoServiceImpl extends GenericServiceImpl<TipoDocumentoEntity, TipoDocumentoDTO,
        CrearTipoDocumentoDTO, ActualizarTipoDocumentoDTO, UUID> implements TipoDocumentoService {

    protected TipoDocumentoServiceImpl(
            TipoDocumentoRepository tipoDocumentoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoDocumentoRepository, modelMapper, authValidator, TipoDocumentoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoDocumentoDTO crearTipoDocumentoDTO) {
        return super.save(crearTipoDocumentoDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoDocumentoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoDocumentoEntity convertCreateDtoToEntity(CrearTipoDocumentoDTO crearTipoDocumentoDTO) {
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.setTipoComprobante(crearTipoDocumentoDTO.getTipoComprobante());
        entity.setSerie(crearTipoDocumentoDTO.getSerie());
        entity.setInicio(crearTipoDocumentoDTO.getInicio());
        entity.setFin(crearTipoDocumentoDTO.getFin());
        entity.setCorrelativoActual(crearTipoDocumentoDTO.getCorrelativoActual());
        entity.setEstado(crearTipoDocumentoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoDocumentoEntity entity, ActualizarTipoDocumentoDTO dto) {
        Optional.ofNullable(dto.getTipoComprobante()).ifPresent(entity::setTipoComprobante);
        Optional.ofNullable(dto.getSerie()).ifPresent(entity::setSerie);
        Optional.ofNullable(dto.getInicio()).ifPresent(entity::setInicio);
        Optional.ofNullable(dto.getFin()).ifPresent(entity::setFin);
        Optional.ofNullable(dto.getCorrelativoActual()).ifPresent(entity::setCorrelativoActual);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}