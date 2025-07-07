package com.saludsystem.application.services.operaciones.impl;

import com.saludsystem.application.dtos.operaciones.get.PresentacionDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearPresentacionDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.operaciones.PresentacionService;
import com.saludsystem.domain.model.operaciones.PresentacionEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.operaciones.PresentacionReposirory;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PresentacionServiceImpl extends GenericServiceImpl<PresentacionEntity, CrearPresentacionDTO,
        PresentacionDTO, UUID> implements PresentacionService {

    public PresentacionServiceImpl(
            PresentacionReposirory presentacionReposirory, ModelMapper modelMapper, AuthValidator authValidator) {
        super(presentacionReposirory, modelMapper, authValidator, PresentacionDTO.class
        );
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
    public ApiResponse update(UUID uuid, CrearPresentacionDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(PresentacionEntity entity, CrearPresentacionDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}