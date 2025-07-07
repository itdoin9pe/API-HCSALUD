package com.saludsystem.application.services.configuracion.impl;

import com.saludsystem.application.dtos.configuracion.get.PermisoDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearPermisoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.configuracion.PermisoService;
import com.saludsystem.domain.model.configuracion.PermisoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.PermisoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PermisoServiceImpl extends GenericServiceImpl<PermisoEntity, CrearPermisoDTO, PermisoDTO, UUID>
        implements PermisoService {

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
    public ApiResponse update(UUID uuid, CrearPermisoDTO updateDto) {
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
    protected void updateEntityFromDto(PermisoEntity entity, CrearPermisoDTO dto) {
        Optional.ofNullable(dto.getInsert()).ifPresent(entity::setInsert);
        Optional.ofNullable(dto.getRead()).ifPresent(entity::setRead);
        Optional.ofNullable(dto.getUpdate()).ifPresent(entity::setUpdate);
        Optional.ofNullable(dto.getDelete()).ifPresent(entity::setDelete);
    }
}