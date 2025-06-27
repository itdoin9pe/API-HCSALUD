package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.dtos.Operaciones.GET.PresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarPresentacionDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Operaciones.PresentacionService;
import com.saludSystem.domain.model.Operaciones.PresentacionEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.PresentacionReposirory;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PresentacionServiceImpl extends GenericServiceImpl<PresentacionEntity, PresentacionDTO, UUID,
        CrearPresentacionDTO, ActualizarPresentacionDTO> implements PresentacionService {

    public PresentacionServiceImpl(PresentacionReposirory presentacionReposirory, ModelMapper modelMapper, AuthValidator authValidator) {
        super(presentacionReposirory, modelMapper, authValidator, PresentacionDTO.class,
                presentacionEntity -> modelMapper.map(presentacionEntity, PresentacionDTO.class));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPresentacionDTO crearPresentacionDTO) {
        return super.save(crearPresentacionDTO);
    }

    @Override
    public ListResponse<PresentacionDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarPresentacionDTO actualizarPresentacionDTO) {
        return super.update(uuid, actualizarPresentacionDTO);
    }

    @Override
    public PresentacionDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<PresentacionDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected PresentacionEntity convertCreateDtoToEntity(CrearPresentacionDTO crearPresentacionDTO) {
        PresentacionEntity entity = new PresentacionEntity();
        entity.setNombre(crearPresentacionDTO.getNombre());
        entity.setEstado(crearPresentacionDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarPresentacionDTO actualizarPresentacionDTO, PresentacionEntity entity) {
        entity.setNombre(actualizarPresentacionDTO.getNombre());
        entity.setEstado(actualizarPresentacionDTO.getEstado());
    }
}