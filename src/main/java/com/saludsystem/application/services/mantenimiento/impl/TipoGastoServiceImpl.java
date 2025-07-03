package com.saludsystem.application.services.mantenimiento.impl;

import com.saludsystem.application.dtos.mantenimiento.get.TipoGastoDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTipoGastoDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarTipoGastoDTO;
import com.saludsystem.application.services.GenericServiceImpl;

import com.saludsystem.application.services.mantenimiento.TipoGastoService;
import com.saludsystem.domain.model.mantenimiento.TipoGastoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.TipoGastoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoGastoServiceImpl extends GenericServiceImpl<TipoGastoEntity, TipoGastoDTO, UUID,
        CrearTipoGastoDTO, ActualizarTipoGastoDTO> implements TipoGastoService {

    public TipoGastoServiceImpl(TipoGastoRepository tipoGastoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoGastoRepository, modelMapper, authValidator, TipoGastoDTO.class,
                tipoGastoEntity -> modelMapper.map(tipoGastoEntity, TipoGastoDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoGastoDTO crearTipoGastoDTO) {
        return super.save(crearTipoGastoDTO);
    }

    @Override
    public ListResponse<TipoGastoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoGastoDTO actualizarTipoGastoDTO) {
        return super.update(uuid, actualizarTipoGastoDTO);
    }

    @Override
    public TipoGastoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoGastoDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoGastoEntity convertCreateDtoToEntity(CrearTipoGastoDTO crearTipoGastoDTO) {
        TipoGastoEntity entity = new TipoGastoEntity();
        entity.setNombre(crearTipoGastoDTO.getNombre());
        entity.setEstado(crearTipoGastoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarTipoGastoDTO actualizarTipoGastoDTO, TipoGastoEntity entity) {
        entity.setNombre(actualizarTipoGastoDTO.getNombre());
        entity.setEstado(actualizarTipoGastoDTO.getEstado());
    }
}