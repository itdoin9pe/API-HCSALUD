package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Mantenimiento.TipoTarjetaService;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoTarjetaDTO;
import com.saludSystem.domain.model.Mantenimiento.TipoTarjetaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TipoTarjetaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoTarjetaServiceImpl extends GenericServiceImpl<TipoTarjetaEntity, TipoTarjetaDTO, UUID,
        CrearTipoTarjetaDTO, ActualizarTipoTarjetaDTO> implements TipoTarjetaService {


    public TipoTarjetaServiceImpl(TipoTarjetaRepository tipoTarjetaRepository, ModelMapper modelMapper,
                                  AuthValidator authValidator) {
        super(tipoTarjetaRepository, modelMapper, authValidator, TipoTarjetaDTO.class,
                tipoTarjetaEntity -> modelMapper.map(tipoTarjetaEntity, TipoTarjetaDTO.class));
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
    public ApiResponse update(UUID uuid, ActualizarTipoTarjetaDTO actualizarTipoTarjetaDTO) {
        return super.update(uuid, actualizarTipoTarjetaDTO);
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
    protected void updateEntityFromDto(ActualizarTipoTarjetaDTO actualizarTipoTarjetaDTO, TipoTarjetaEntity entity) {
        entity.setDescripcion(actualizarTipoTarjetaDTO.getDescripcion());
        entity.setEstado(actualizarTipoTarjetaDTO.getEstado());
    }
}