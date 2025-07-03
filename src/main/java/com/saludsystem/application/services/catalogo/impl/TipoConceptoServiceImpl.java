package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.get.TipoConceptoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearTipoConceptoDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarTipoConceptoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.catalogo.TipoConceptoService;
import com.saludsystem.domain.model.catalogo.TipoConceptoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.TipoConceptoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoConceptoServiceImpl extends GenericServiceImpl<TipoConceptoEntity, TipoConceptoDTO, UUID,
        CrearTipoConceptoDTO, ActualizarTipoConceptoDTO> implements TipoConceptoService {

    public TipoConceptoServiceImpl(TipoConceptoRepository tipoConceptoRepository, ModelMapper modelMapper,
                                   AuthValidator authValidator) {
        super(tipoConceptoRepository, modelMapper, authValidator, TipoConceptoDTO.class,
                tipoConceptoEntity -> modelMapper.map(tipoConceptoEntity, TipoConceptoDTO.class));
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
    public ApiResponse update(UUID uuid, ActualizarTipoConceptoDTO actualizarTipoConceptoDTO) {
        return super.update(uuid, actualizarTipoConceptoDTO);
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
    protected void updateEntityFromDto(ActualizarTipoConceptoDTO actualizarTipoConceptoDTO, TipoConceptoEntity entity) {
        entity.setNombre(actualizarTipoConceptoDTO.getNombre());
        entity.setEstado(actualizarTipoConceptoDTO.getEstado());
    }
}