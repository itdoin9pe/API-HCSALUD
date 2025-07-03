package com.saludsystem.application.services.operaciones.impl;

import com.saludsystem.application.dtos.operaciones.get.UnidadDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearUnidadDTO;
import com.saludsystem.application.dtos.operaciones.put.ActualizarUnidadDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.operaciones.UnidadService;
import com.saludsystem.domain.model.operaciones.UnidadEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.operaciones.UnidadRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UnidadServiceImpl extends GenericServiceImpl<UnidadEntity, UnidadDTO, UUID,
        CrearUnidadDTO, ActualizarUnidadDTO> implements UnidadService {

    public UnidadServiceImpl(UnidadRepository unidadRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(unidadRepository, modelMapper, authValidator, UnidadDTO.class,
                unidadEntity -> modelMapper.map(unidadEntity, UnidadDTO.class));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearUnidadDTO crearUnidadDTO) {
        return super.save(crearUnidadDTO);
    }

    @Override
    public ListResponse<UnidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarUnidadDTO actualizarUnidadDTO) {
        return super.update(uuid, actualizarUnidadDTO);
    }

    @Override
    public List<UnidadDTO> getList() {
        return super.getList();
    }

    @Override
    public UnidadDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected UnidadEntity convertCreateDtoToEntity(CrearUnidadDTO crearUnidadDTO) {
        UnidadEntity entity = new UnidadEntity();
        entity.setNombre(crearUnidadDTO.getNombre());
        entity.setSiglas(crearUnidadDTO.getSiglas());
        entity.setDescripcion(crearUnidadDTO.getDescripcion());
        entity.setEstado(crearUnidadDTO.getEstado());
        return null;
    }

    @Override
    protected void updateEntityFromDto(ActualizarUnidadDTO actualizarUnidadDTO, UnidadEntity entity) {
        entity.setNombre(actualizarUnidadDTO.getNombre());
        entity.setSiglas(actualizarUnidadDTO.getSiglas());
        entity.setDescripcion(actualizarUnidadDTO.getDescripcion());
        entity.setEstado(actualizarUnidadDTO.getEstado());
    }
}