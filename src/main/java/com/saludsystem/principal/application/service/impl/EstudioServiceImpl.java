package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.get.EstudioDTO;
import com.saludsystem.principal.application.dto.post.CrearEstudioDTO;
import com.saludsystem.principal.application.dto.put.ActualizarEstudioDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.principal.application.service.EstudioService;
import com.saludsystem.principal.domain.model.EstudioEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.EstudioRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstudioServiceImpl extends GenericServiceImpl<EstudioEntity, EstudioDTO, CrearEstudioDTO,
        ActualizarEstudioDTO, UUID> implements EstudioService {

    public EstudioServiceImpl(EstudioRepository estudioRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(estudioRepository, modelMapper, authValidator, EstudioDTO.class
        );
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
    public ApiResponse update(UUID uuid, ActualizarEstudioDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(EstudioEntity entity, ActualizarEstudioDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
    }
}