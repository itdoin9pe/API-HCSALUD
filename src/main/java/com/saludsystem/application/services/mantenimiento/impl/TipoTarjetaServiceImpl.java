package com.saludsystem.application.services.mantenimiento.impl;

import com.saludsystem.application.dtos.mantenimiento.get.TipoTarjetaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTipoTarjetaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.mantenimiento.TipoTarjetaService;
import com.saludsystem.domain.model.mantenimiento.TipoTarjetaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.TipoTarjetaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoTarjetaServiceImpl extends GenericServiceImpl<TipoTarjetaEntity, CrearTipoTarjetaDTO, TipoTarjetaDTO,
        UUID> implements TipoTarjetaService {

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
    public ApiResponse update(UUID uuid, CrearTipoTarjetaDTO updateDto) {
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
    protected void updateEntityFromDto(TipoTarjetaEntity entity, CrearTipoTarjetaDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}