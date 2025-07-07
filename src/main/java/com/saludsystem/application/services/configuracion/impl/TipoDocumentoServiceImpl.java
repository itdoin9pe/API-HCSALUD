package com.saludsystem.application.services.configuracion.impl;

import com.saludsystem.application.dtos.configuracion.get.TipoDocumentoDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearTipoDocumentoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.configuracion.TipoDocumentoService;
import com.saludsystem.domain.model.configuracion.TipoDocumentoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.TipoDocumentoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoDocumentoServiceImpl extends GenericServiceImpl<TipoDocumentoEntity, CrearTipoDocumentoDTO,
        TipoDocumentoDTO, UUID> implements TipoDocumentoService {

    protected TipoDocumentoServiceImpl(
            TipoDocumentoRepository tipoDocumentoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(tipoDocumentoRepository, modelMapper, authValidator, TipoDocumentoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoDocumentoDTO crearTipoDocumentoDTO) {
        return super.save(crearTipoDocumentoDTO);
    }

    @Override
    public ListResponse<TipoDocumentoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearTipoDocumentoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public TipoDocumentoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoDocumentoDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoDocumentoEntity convertCreateDtoToEntity(CrearTipoDocumentoDTO crearTipoDocumentoDTO) {
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.setTipoComprobante(crearTipoDocumentoDTO.getTipoComprobante());
        entity.setSerie(crearTipoDocumentoDTO.getSerie());
        entity.setInicio(crearTipoDocumentoDTO.getInicio());
        entity.setFin(crearTipoDocumentoDTO.getFin());
        entity.setCorrelativoActual(crearTipoDocumentoDTO.getCorrelativoActual());
        entity.setEstado(crearTipoDocumentoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(TipoDocumentoEntity entity, CrearTipoDocumentoDTO dto) {
        Optional.ofNullable(dto.getTipoComprobante()).ifPresent(entity::setTipoComprobante);
        Optional.ofNullable(dto.getSerie()).ifPresent(entity::setSerie);
        Optional.ofNullable(dto.getInicio()).ifPresent(entity::setInicio);
        Optional.ofNullable(dto.getFin()).ifPresent(entity::setFin);
        Optional.ofNullable(dto.getCorrelativoActual()).ifPresent(entity::setCorrelativoActual);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}