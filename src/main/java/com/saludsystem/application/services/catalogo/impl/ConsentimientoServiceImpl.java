package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.get.ConsentimientoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearConsentimientoDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarConsentimientoDTO;
import com.saludsystem.application.services.catalogo.ConsentimientoService;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.domain.model.catalogo.ConsentimientoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.ConsentimientoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsentimientoServiceImpl extends GenericServiceImpl<ConsentimientoEntity, ConsentimientoDTO, UUID,
        CrearConsentimientoDTO, ActualizarConsentimientoDTO> implements ConsentimientoService {

    public ConsentimientoServiceImpl(ConsentimientoRepository consentimientoRepository, ModelMapper modelMapper,
                                     AuthValidator authValidator) {
        super(consentimientoRepository, modelMapper, authValidator, ConsentimientoDTO.class,
                consentimientoEntity -> modelMapper.map(consentimientoEntity, ConsentimientoDTO.class));
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
    public ApiResponse update(UUID uuid, ActualizarConsentimientoDTO actualizarConsentimientoDTO) {
        return super.update(uuid, actualizarConsentimientoDTO);
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
    protected void updateEntityFromDto(ActualizarConsentimientoDTO actualizarConsentimientoDTO, ConsentimientoEntity entity) {
        entity.setNombre(actualizarConsentimientoDTO.getNombre());
        entity.setObservacion(actualizarConsentimientoDTO.getObservacion());
        entity.setTexto(actualizarConsentimientoDTO.getTexto());
        entity.setEstado(actualizarConsentimientoDTO.getEstado());
    }
}