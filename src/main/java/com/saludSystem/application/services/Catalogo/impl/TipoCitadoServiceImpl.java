package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoCitadoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoCitadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.TipoCitadoDTO;
import com.saludSystem.application.services.Catalogo.TipoCitadoService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Catalogo.TipoCitadoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.TipoCitadoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
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