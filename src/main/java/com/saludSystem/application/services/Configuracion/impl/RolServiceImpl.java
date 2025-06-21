package com.saludSystem.application.services.Configuracion.impl;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarRolDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearRolDTO;
import com.saludSystem.application.dtos.Configuracion.GET.RolDTO;
import com.saludSystem.application.services.Configuracion.RolService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Configuracion.RoleEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.RoleRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RolServiceImpl extends GenericServiceImpl<
        RoleEntity, RolDTO, UUID, CrearRolDTO, ActualizarRolDTO> implements RolService {

    public RolServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(roleRepository, modelMapper, authValidator, RolDTO.class,
                roleEntity -> modelMapper.map(roleEntity, RolDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearRolDTO crearRolDTO) {
        return super.save(crearRolDTO);
    }

    @Override
    public ListResponse<RolDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarRolDTO actualizarRolDTO) {
        return super.update(uuid, actualizarRolDTO);
    }

    @Override
    public List<RolDTO> getList() {
        return super.getList();
    }

    @Override
    public RolDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected RoleEntity convertCreateDtoToEntity(CrearRolDTO crearRolDTO) {
        RoleEntity entity = new RoleEntity();
        entity.setNombre(crearRolDTO.getNombre());
        entity.setEstado(crearRolDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarRolDTO actualizarRolDTO, RoleEntity entity) {
        entity.setNombre(actualizarRolDTO.getNombre());
        entity.setEstado(actualizarRolDTO.getEstado());
    }
}