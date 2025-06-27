package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Operaciones.CategoriaMatService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarCategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.GET.CategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearCategotiaMatDTO;
import com.saludSystem.domain.model.Operaciones.CategoriaMatEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.CategoriaMatRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaMatServiceImpl extends GenericServiceImpl<CategoriaMatEntity, CategoriaMatDTO, UUID,
        CrearCategotiaMatDTO, ActualizarCategoriaMatDTO> implements CategoriaMatService {

    public CategoriaMatServiceImpl(CategoriaMatRepository categoriaMatRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(categoriaMatRepository, modelMapper, authValidator, CategoriaMatDTO.class,
                categoriaMatEntity -> modelMapper.map(categoriaMatEntity, CategoriaMatDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearCategotiaMatDTO crearCategotiaMatDTO) {
        return super.save(crearCategotiaMatDTO);
    }

    @Override
    public ListResponse<CategoriaMatDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarCategoriaMatDTO actualizarCategoriaMatDTO) {
        return super.update(uuid, actualizarCategoriaMatDTO);
    }

    @Override
    public CategoriaMatDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CategoriaMatDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected CategoriaMatEntity convertCreateDtoToEntity(CrearCategotiaMatDTO crearCategotiaMatDTO) {
        CategoriaMatEntity entity = new CategoriaMatEntity();
        entity.setNombre(crearCategotiaMatDTO.getNombre());
        entity.setDescripcion(crearCategotiaMatDTO.getDescripcion());
        entity.setEstado(crearCategotiaMatDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarCategoriaMatDTO actualizarCategoriaMatDTO, CategoriaMatEntity entity) {
        entity.setNombre(actualizarCategoriaMatDTO.getNombre());
        entity.setDescripcion(actualizarCategoriaMatDTO.getDescripcion());
        entity.setEstado(actualizarCategoriaMatDTO.getEstado());
    }
}