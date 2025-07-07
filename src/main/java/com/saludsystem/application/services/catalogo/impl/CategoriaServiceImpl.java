package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.req.CategoriaDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearCategoriaDTO;
import com.saludsystem.application.services.catalogo.CategoriaService;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.domain.model.catalogo.CategoriaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.CategoriaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaServiceImpl extends GenericServiceImpl<CategoriaEntity,
        CrearCategoriaDTO,CategoriaDTO, UUID> implements CategoriaService {

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ModelMapper modelMapper,
                                AuthValidator authValidator) {
        super(categoriaRepository, modelMapper, authValidator, CategoriaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearCategoriaDTO dto) {
        return save(dto);
    }

    @Override
    public ListResponse<CategoriaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearCategoriaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    public CategoriaDTO getById(UUID id) {
        return super.getById(id);
    }

    @Override
    protected CategoriaEntity convertCreateDtoToEntity(CrearCategoriaDTO crearCategoriaDTO) {
        CategoriaEntity entity = new CategoriaEntity();
        entity.setNombre(crearCategoriaDTO.getNombre());
        entity.setEstado(crearCategoriaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CategoriaEntity entity, CrearCategoriaDTO dto) {
        Optional.ofNullable(dto.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}