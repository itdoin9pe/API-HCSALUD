package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Mantenimiento.TipoPagoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoPagoDTO;
import com.saludSystem.domain.model.Mantenimiento.TipoPagoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TipoPagoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoPagoServiceImpl extends GenericServiceImpl<TipoPagoEntity, TipoPagoDTO, UUID,
        CrearTipoPagoDTO, ActualizarTipoPagoDTO> implements TipoPagoService {

    public TipoPagoServiceImpl(TipoPagoRepository tipoPagoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoPagoRepository, modelMapper, authValidator, TipoPagoDTO.class,
                tipoPagoEntity -> modelMapper.map(tipoPagoEntity, TipoPagoDTO.class));
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
    public ApiResponse update(UUID uuid, ActualizarTipoPagoDTO actualizarTipoPagoDTO) {
        return super.update(uuid, actualizarTipoPagoDTO);
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
    protected void updateEntityFromDto(ActualizarTipoPagoDTO actualizarTipoPagoDTO, TipoPagoEntity entity) {
        entity.setDescripcion(actualizarTipoPagoDTO.getDescripcion());
        entity.setMetodoPago(actualizarTipoPagoDTO.getMetodoPago());
        entity.setEstado(actualizarTipoPagoDTO.getEstado());
    }
}