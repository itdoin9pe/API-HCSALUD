package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.get.TipoTarjetaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTipoTarjetaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTipoTarjetaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.TipoTarjetaService;
import com.saludsystem.mantenimiento.domain.model.TipoTarjetaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoTarjetaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoTarjetaServiceImpl extends GenericServiceImpl<TipoTarjetaEntity, TipoTarjetaDTO, CrearTipoTarjetaDTO,
        ActualizarTipoTarjetaDTO, UUID> implements TipoTarjetaService {

    protected TipoTarjetaServiceImpl(
            TipoTarjetaRepository tipoTarjetaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoTarjetaRepository, modelMapper, authValidator, TipoTarjetaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoTarjetaDTO crearTipoTarjetaDTO) {
        return super.save(crearTipoTarjetaDTO);
    }

    @Override
    public ListResponse<TipoTarjetaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoTarjetaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoTarjetaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoTarjetaDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoTarjetaEntity convertCreateDtoToEntity(CrearTipoTarjetaDTO crearTipoTarjetaDTO) {
        TipoTarjetaEntity entity = new TipoTarjetaEntity();
        entity.setDescripcion(crearTipoTarjetaDTO.getDescripcion());
        entity.setEstado(crearTipoTarjetaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoTarjetaEntity entity, ActualizarTipoTarjetaDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}