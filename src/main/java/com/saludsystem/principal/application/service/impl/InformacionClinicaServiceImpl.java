package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.res.InformacionClinicaDTO;
import com.saludsystem.principal.application.dto.req.CrearInformacionClinicaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.principal.application.service.InformacionClinicaService;
import com.saludsystem.principal.domain.model.InformacionClinicaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.InformacionClinicaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InformacionClinicaServiceImpl extends GenericServiceImpl<InformacionClinicaEntity,
        CrearInformacionClinicaDTO, InformacionClinicaDTO, UUID> implements InformacionClinicaService {

    public InformacionClinicaServiceImpl(
            InformacionClinicaRepository informacionClinicaRepository,
            ModelMapper modelMapper, AuthValidator authValidator) {
        super(informacionClinicaRepository, modelMapper, authValidator, InformacionClinicaDTO.class
        );
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
    public ApiResponse update(UUID uuid, CrearInformacionClinicaDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(InformacionClinicaEntity entity, CrearInformacionClinicaDTO dto) {
        entity.setNombre(dto.getNombre());
        entity.setEstado(dto.getEstado());
    }
}