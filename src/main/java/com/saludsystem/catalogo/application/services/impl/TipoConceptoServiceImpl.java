package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.get.TipoConceptoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearTipoConceptoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarTipoConceptoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.application.services.TipoConceptoService;
import com.saludsystem.catalogo.domain.model.TipoConceptoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.TipoConceptoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoConceptoServiceImpl extends GenericServiceImpl<TipoConceptoEntity, TipoConceptoDTO,
        CrearTipoConceptoDTO, ActualizarTipoConceptoDTO, UUID> implements TipoConceptoService {

    protected TipoConceptoServiceImpl(
            TipoConceptoRepository tipoConceptoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoConceptoRepository, modelMapper, authValidator, TipoConceptoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoConceptoDTO tipoConceptoDTO) {
        return super.save(tipoConceptoDTO);
    }

    @Override
    public ListResponse<TipoConceptoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoConceptoDTO updateDto) {
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
    protected TipoConceptoEntity convertCreateDtoToEntity(CrearTipoConceptoDTO tipoConceptoDTO) {
        TipoConceptoEntity entity = new TipoConceptoEntity();
        entity.setNombre(tipoConceptoDTO.getNombre());
        entity.setEstado(tipoConceptoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoConceptoEntity entity, ActualizarTipoConceptoDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}