package com.saludsystem.application.services.operaciones.impl;

import com.saludsystem.application.dtos.operaciones.get.MarcaDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearMarcaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.operaciones.MarcaService;
import com.saludsystem.domain.model.operaciones.MarcaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.operaciones.MarcaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MarcaServiceImpl extends GenericServiceImpl<MarcaEntity, CrearMarcaDTO, MarcaDTO, UUID>
        implements MarcaService {

    protected MarcaServiceImpl(MarcaRepository marcaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(marcaRepository, modelMapper, authValidator, MarcaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearMarcaDTO crearMarcaDTO) {
        return super.save(crearMarcaDTO);
    }

    @Override
    public ListResponse<MarcaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearMarcaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<MarcaDTO> getList() {
        return super.getList();
    }

    @Override
    public MarcaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected MarcaEntity convertCreateDtoToEntity(CrearMarcaDTO crearMarcaDTO) {
        MarcaEntity entity = new MarcaEntity();
        entity.setNombre(crearMarcaDTO.getNombre());
        entity.setEstado(crearMarcaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(MarcaEntity entity, CrearMarcaDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}