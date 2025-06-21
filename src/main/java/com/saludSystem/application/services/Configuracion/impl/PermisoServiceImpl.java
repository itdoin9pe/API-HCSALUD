package com.saludSystem.application.services.Configuracion.impl;

import com.saludSystem.application.dtos.Configuracion.GET.PermisoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearPermisoDTO;
import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarPermisoDTO;
import com.saludSystem.application.services.Configuracion.PermisoService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Configuracion.PermisoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.PermisoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermisoServiceImpl extends GenericServiceImpl<PermisoEntity, PermisoDTO, UUID,
        CrearPermisoDTO, ActualizarPermisoDTO> implements PermisoService {

    public PermisoServiceImpl(PermisoRepository permisoRepository, ModelMapper modelMapper,
                              AuthValidator authValidator) {
        super(permisoRepository, modelMapper, authValidator, PermisoDTO.class,
                permisoEntity -> modelMapper.map(permisoEntity, PermisoDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearPermisoDTO crearPermisoDTO) {
        return super.save(crearPermisoDTO);
    }

    @Override
    public ListResponse<PermisoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarPermisoDTO actualizarPermisoDTO) {
        return super.update(uuid, actualizarPermisoDTO);
    }

    @Override
    public PermisoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<PermisoDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected PermisoEntity convertCreateDtoToEntity(CrearPermisoDTO crearPermisoDTO) {
        PermisoEntity entity = new PermisoEntity();
        entity.setInsert(crearPermisoDTO.getInsert());
        entity.setRead(crearPermisoDTO.getRead());
        entity.setUpdate(crearPermisoDTO.getUpdate());
        entity.setDelete(crearPermisoDTO.getDelete());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarPermisoDTO actualizarPermisoDTO, PermisoEntity entity) {
        entity.setInsert(actualizarPermisoDTO.getInsert());
        entity.setRead(actualizarPermisoDTO.getRead());
        entity.setUpdate(actualizarPermisoDTO.getUpdate());
        entity.setDelete(actualizarPermisoDTO.getDelete());
    }
}