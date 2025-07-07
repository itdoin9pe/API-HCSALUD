package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.req.TipoCitadoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearTipoCitadoDTO;
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
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoCitadoServiceImpl extends GenericServiceImpl<TipoCitadoEntity, CrearTipoCitadoDTO, TipoCitadoDTO, UUID>
        implements TipoCitadoService {

    protected TipoCitadoServiceImpl(
            TipoCitadoRepository tipoCitadoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoCitadoRepository, modelMapper, authValidator, TipoCitadoDTO.class);
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
    public ApiResponse update(UUID uuid, CrearTipoCitadoDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(TipoCitadoEntity entity, CrearTipoCitadoDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getColor()).ifPresent(entity::setColor);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}