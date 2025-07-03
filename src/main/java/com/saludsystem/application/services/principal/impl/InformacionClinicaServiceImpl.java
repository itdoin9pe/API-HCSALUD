package com.saludsystem.application.services.principal.impl;

import com.saludsystem.application.dtos.principal.get.InformacionClinicaDTO;
import com.saludsystem.application.dtos.principal.post.CrearInformacionClinicaDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarInformacionClinicaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.principal.InformacionClinicaService;
import com.saludsystem.domain.model.principal.InformacionClinicaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.principal.InformacionClinicaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InformacionClinicaServiceImpl extends GenericServiceImpl<InformacionClinicaEntity, InformacionClinicaDTO,
        UUID, CrearInformacionClinicaDTO, ActualizarInformacionClinicaDTO> implements InformacionClinicaService {

    public InformacionClinicaServiceImpl(
            InformacionClinicaRepository informacionClinicaRepository,
            ModelMapper modelMapper, AuthValidator authValidator) {
        super(informacionClinicaRepository, modelMapper, authValidator, InformacionClinicaDTO.class,
                informacionClinicaEntity -> modelMapper.map
                        (informacionClinicaEntity, InformacionClinicaDTO.class));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearInformacionClinicaDTO crearInformacionClinicaDTO) {
        return super.save(crearInformacionClinicaDTO);
    }

    @Override
    public ListResponse<InformacionClinicaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO) {
        return super.update(uuid, actualizarInformacionClinicaDTO);
    }

    @Override
    public List<InformacionClinicaDTO> getList() {
        return super.getList();
    }

    @Override
    public InformacionClinicaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected InformacionClinicaEntity convertCreateDtoToEntity(CrearInformacionClinicaDTO crearInformacionClinicaDTO) {
        InformacionClinicaEntity entity = new InformacionClinicaEntity();
        entity.setNombre(crearInformacionClinicaDTO.getNombre());
        entity.setEstado(crearInformacionClinicaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(
            ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO,
            InformacionClinicaEntity entity) {
        entity.setNombre(actualizarInformacionClinicaDTO.getNombre());
        entity.setEstado(actualizarInformacionClinicaDTO.getEstado());
    }
}