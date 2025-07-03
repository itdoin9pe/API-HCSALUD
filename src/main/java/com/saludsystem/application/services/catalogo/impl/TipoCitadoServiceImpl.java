package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.get.TipoCitadoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearTipoCitadoDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarTipoCitadoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.catalogo.TipoCitadoService;
import com.saludsystem.domain.model.catalogo.TipoCitadoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.TipoCitadoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoCitadoServiceImpl extends GenericServiceImpl<TipoCitadoEntity, TipoCitadoDTO, UUID,
        CrearTipoCitadoDTO, ActualizarTipoCitadoDTO> implements TipoCitadoService {

    public TipoCitadoServiceImpl(TipoCitadoRepository tipoCitadoRepository, ModelMapper modelMapper,
                                 AuthValidator authValidator) {
        super(tipoCitadoRepository, modelMapper, authValidator, TipoCitadoDTO.class,
                tipoCitadoEntity -> modelMapper.map(tipoCitadoEntity, TipoCitadoDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoCitadoDTO crearTipoCitadoDTO) {
        return super.save(crearTipoCitadoDTO);
    }

    @Override
    public ListResponse<TipoCitadoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoCitadoDTO actualizarTipoCitadoDTO) {
        return super.update(uuid, actualizarTipoCitadoDTO);
    }

    @Override
    public TipoCitadoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoCitadoDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoCitadoEntity convertCreateDtoToEntity(CrearTipoCitadoDTO crearTipoCitadoDTO) {
        TipoCitadoEntity entity = new TipoCitadoEntity();
        entity.setNombre(crearTipoCitadoDTO.getNombre());
        entity.setColor(crearTipoCitadoDTO.getColor());
        entity.setEstado(crearTipoCitadoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarTipoCitadoDTO actualizarTipoCitadoDTO, TipoCitadoEntity entity) {
        entity.setNombre(actualizarTipoCitadoDTO.getNombre());
        entity.setColor(actualizarTipoCitadoDTO.getColor());
        entity.setEstado(actualizarTipoCitadoDTO.getEstado());
    }
}