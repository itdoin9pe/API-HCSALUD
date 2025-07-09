package com.saludsystem.configuracion.application.services.impl;

import com.saludsystem.configuracion.application.dto.get.PermisoDTO;
import com.saludsystem.configuracion.application.dto.post.CrearPermisoDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarPermisoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.configuracion.application.services.PermisoService;
import com.saludsystem.configuracion.domain.model.PermisoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.PermisoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PermisoServiceImpl extends GenericServiceImpl<PermisoEntity, PermisoDTO, CrearPermisoDTO,
        ActualizarPermisoDTO, UUID> implements PermisoService {

    protected PermisoServiceImpl(
            PermisoRepository permisoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(permisoRepository, modelMapper, authValidator, PermisoDTO.class);
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
    public ApiResponse update(UUID uuid, ActualizarPermisoDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(PermisoEntity entity, ActualizarPermisoDTO dto) {
        Optional.ofNullable(dto.getInsert()).ifPresent(entity::setInsert);
        Optional.ofNullable(dto.getRead()).ifPresent(entity::setRead);
        Optional.ofNullable(dto.getUpdate()).ifPresent(entity::setUpdate);
        Optional.ofNullable(dto.getDelete()).ifPresent(entity::setDelete);
    }
}