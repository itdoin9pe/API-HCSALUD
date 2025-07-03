package com.saludsystem.application.services.principal.impl;

import com.saludsystem.application.dtos.principal.get.AseguradoraDTO;
import com.saludsystem.application.dtos.principal.post.CrearAseguradoraDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarAseguradoraDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.principal.AseguradoraService;
import com.saludsystem.domain.model.principal.AseguradoraEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.principal.AseguradoraRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AseguradoraServiceImpl extends GenericServiceImpl<AseguradoraEntity, AseguradoraDTO, UUID,
        CrearAseguradoraDTO, ActualizarAseguradoraDTO> implements AseguradoraService {

    public AseguradoraServiceImpl(AseguradoraRepository aseguradoraRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(aseguradoraRepository, modelMapper, authValidator, AseguradoraDTO.class,
                aseguradoraEntity -> modelMapper.map(aseguradoraEntity, AseguradoraDTO.class));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearAseguradoraDTO crearAseguradoraDTO) {
        return super.save(crearAseguradoraDTO);
    }

    @Override
    public ListResponse<AseguradoraDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarAseguradoraDTO actualizarAseguradoraDTO) {
        return super.update(uuid, actualizarAseguradoraDTO);
    }

    @Override
    public List<AseguradoraDTO> getList() {
        return super.getList();
    }

    @Override
    public AseguradoraDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected AseguradoraEntity convertCreateDtoToEntity(CrearAseguradoraDTO crearAseguradoraDTO) {
        AseguradoraEntity entity =  new AseguradoraEntity();
        entity.setDescripcion(crearAseguradoraDTO.getDescripcion());
        entity.setEstado(crearAseguradoraDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarAseguradoraDTO actualizarAseguradoraDTO, AseguradoraEntity entity) {
        entity.setDescripcion(actualizarAseguradoraDTO.getDescripcion());
        entity.setEstado(actualizarAseguradoraDTO.getEstado());
    }
}