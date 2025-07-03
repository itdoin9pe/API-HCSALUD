package com.saludsystem.application.services.principal.impl;

import com.saludsystem.application.dtos.principal.get.EstudioDTO;
import com.saludsystem.application.dtos.principal.post.CrearEstudioDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarEstudioDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.principal.EstudioService;
import com.saludsystem.domain.model.principal.EstudioEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.principal.EstudioRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstudioServiceImpl extends GenericServiceImpl<EstudioEntity, EstudioDTO, UUID,
        CrearEstudioDTO, ActualizarEstudioDTO> implements EstudioService {


    public EstudioServiceImpl(EstudioRepository estudioRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(estudioRepository, modelMapper, authValidator, EstudioDTO.class,
                estudioEntity -> modelMapper.map(estudioEntity, EstudioDTO.class));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearEstudioDTO crearEstudioDTO) {
        return super.save(crearEstudioDTO);
    }

    @Override
    public ListResponse<EstudioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarEstudioDTO actualizarEstudioDTO) {
        return super.update(uuid, actualizarEstudioDTO);
    }

    @Override
    public EstudioDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EstudioDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected EstudioEntity convertCreateDtoToEntity(CrearEstudioDTO crearEstudioDTO) {
        EstudioEntity entity = new EstudioEntity();
        entity.setDescripcion(crearEstudioDTO.getDescripcion());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarEstudioDTO actualizarEstudioDTO, EstudioEntity entity) {
        entity.setDescripcion(actualizarEstudioDTO.getDescripcion());
    }
}