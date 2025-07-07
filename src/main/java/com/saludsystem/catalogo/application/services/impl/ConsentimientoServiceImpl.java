package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.ConsentimientoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearConsentimientoDTO;
import com.saludsystem.catalogo.application.services.ConsentimientoService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.ConsentimientoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.ConsentimientoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsentimientoServiceImpl extends GenericServiceImpl<ConsentimientoEntity, CrearConsentimientoDTO,
        ConsentimientoDTO, UUID> implements ConsentimientoService {

    protected ConsentimientoServiceImpl(
            ConsentimientoRepository consentimientoRepository,
            ModelMapper modelMapper, AuthValidator authValidator) {
        super(consentimientoRepository, modelMapper, authValidator, ConsentimientoDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearConsentimientoDTO crearConsentimientoDTO) {
        return super.save(crearConsentimientoDTO);
    }

    @Override
    public ListResponse<ConsentimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearConsentimientoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    public ConsentimientoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ConsentimientoDTO> getList() {
        return super.getList();
    }

    @Override
    protected ConsentimientoEntity convertCreateDtoToEntity(CrearConsentimientoDTO crearConsentimientoDTO) {
        ConsentimientoEntity entity = new ConsentimientoEntity();
        entity.setNombre(crearConsentimientoDTO.getNombre());
        entity.setObservacion(crearConsentimientoDTO.getObservacion());
        entity.setTexto(crearConsentimientoDTO.getTexto());
        entity.setEstado(crearConsentimientoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ConsentimientoEntity entity, CrearConsentimientoDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getObservacion()).ifPresent(entity::setObservacion);
        Optional.ofNullable(dto.getTexto()).ifPresent(entity::setTexto);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}