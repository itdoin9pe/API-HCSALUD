package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.req.TipoConceptoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearTipoConceptoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.catalogo.TipoConceptoService;
import com.saludsystem.domain.model.catalogo.TipoConceptoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.TipoConceptoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoConceptoServiceImpl extends GenericServiceImpl<TipoConceptoEntity, CrearTipoConceptoDTO,
        TipoConceptoDTO, UUID> implements TipoConceptoService {

    protected TipoConceptoServiceImpl(
            TipoConceptoRepository tipoConceptoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoConceptoRepository, modelMapper, authValidator, TipoConceptoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoConceptoDTO crearTipoConceptoDTO) {
        return super.save(crearTipoConceptoDTO);
    }

    @Override
    public ListResponse<TipoConceptoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearTipoConceptoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoConceptoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoConceptoDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoConceptoEntity convertCreateDtoToEntity(CrearTipoConceptoDTO crearTipoConceptoDTO) {
        TipoConceptoEntity entity = new TipoConceptoEntity();
        entity.setNombre(crearTipoConceptoDTO.getNombre());
        entity.setEstado(crearTipoConceptoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoConceptoEntity entity, CrearTipoConceptoDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}