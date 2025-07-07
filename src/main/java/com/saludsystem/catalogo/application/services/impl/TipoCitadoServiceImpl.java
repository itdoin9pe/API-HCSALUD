package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.TipoCitadoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearTipoCitadoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.application.services.TipoCitadoService;
import com.saludsystem.catalogo.domain.model.TipoCitadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.TipoCitadoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
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