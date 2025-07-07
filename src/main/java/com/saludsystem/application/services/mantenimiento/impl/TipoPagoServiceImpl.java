package com.saludsystem.application.services.mantenimiento.impl;

import com.saludsystem.application.dtos.mantenimiento.get.TipoPagoDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTipoPagoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.mantenimiento.TipoPagoService;
import com.saludsystem.domain.model.mantenimiento.TipoPagoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.TipoPagoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoPagoServiceImpl extends GenericServiceImpl<TipoPagoEntity, CrearTipoPagoDTO, TipoPagoDTO, UUID>
        implements TipoPagoService {

    protected TipoPagoServiceImpl(
            TipoPagoRepository tipoPagoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoPagoRepository, modelMapper, authValidator, TipoPagoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoPagoDTO crearTipoPagoDTO) {
        return super.save(crearTipoPagoDTO);
    }

    @Override
    public ListResponse<TipoPagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearTipoPagoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoPagoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoPagoDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoPagoEntity convertCreateDtoToEntity(CrearTipoPagoDTO crearTipoPagoDTO) {
        TipoPagoEntity entity = new TipoPagoEntity();
        entity.setDescripcion(crearTipoPagoDTO.getDescripcion());
        entity.setMetodoPago(crearTipoPagoDTO.getMetodoPago());
        entity.setEstado(crearTipoPagoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoPagoEntity entity, CrearTipoPagoDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getMetodoPago()).ifPresent(entity::setMetodoPago);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}