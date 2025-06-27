package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.dtos.Operaciones.GET.TipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearTipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarTipoMaterialDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Operaciones.TipoMaterialService;
import com.saludSystem.domain.model.Operaciones.TipoMaterialEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.TipoMaterialRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoMaterialServiceImpl extends GenericServiceImpl<TipoMaterialEntity, TipoMaterialDTO, UUID,
        CrearTipoMaterialDTO, ActualizarTipoMaterialDTO> implements TipoMaterialService {

    public TipoMaterialServiceImpl(TipoMaterialRepository tipoMaterialRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoMaterialRepository, modelMapper, authValidator, TipoMaterialDTO.class,
                tipoMaterialEntity -> modelMapper.map(tipoMaterialEntity, TipoMaterialDTO.class));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearTipoMaterialDTO crearTipoMaterialDTO) {
        return super.save(crearTipoMaterialDTO);
    }

    @Override
    public ListResponse<TipoMaterialDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarTipoMaterialDTO actualizarTipoMaterialDTO) {
        return super.update(uuid, actualizarTipoMaterialDTO);
    }

    @Override
    public TipoMaterialDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoMaterialDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoMaterialEntity convertCreateDtoToEntity(CrearTipoMaterialDTO crearTipoMaterialDTO) {
        TipoMaterialEntity entity = new TipoMaterialEntity();
        entity.setNombre(crearTipoMaterialDTO.getNombre());
        entity.setDescripcion(crearTipoMaterialDTO.getDescripcion());
        entity.setEstado(crearTipoMaterialDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarTipoMaterialDTO actualizarTipoMaterialDTO, TipoMaterialEntity entity) {
        entity.setNombre(actualizarTipoMaterialDTO.getNombre());
        entity.setDescripcion(actualizarTipoMaterialDTO.getDescripcion());
        entity.setEstado(actualizarTipoMaterialDTO.getEstado());
    }
}