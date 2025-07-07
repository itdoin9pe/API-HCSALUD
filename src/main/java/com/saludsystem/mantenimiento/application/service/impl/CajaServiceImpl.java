package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.res.CajaDTO;
import com.saludsystem.mantenimiento.application.dto.req.CrearCajaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.CajaService;
import com.saludsystem.mantenimiento.domain.model.CajaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.CajaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CajaServiceImpl extends GenericServiceImpl<CajaEntity, CrearCajaDTO, CajaDTO, UUID>
        implements CajaService {

    protected CajaServiceImpl(CajaRepository cajaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(cajaRepository, modelMapper, authValidator, CajaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearCajaDTO crearCajaDTO) {
        return super.save(crearCajaDTO);
    }

    @Override
    public ListResponse<CajaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearCajaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public CajaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CajaDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected CajaEntity convertCreateDtoToEntity(CrearCajaDTO crearCajaDTO) {
        CajaEntity entity = new CajaEntity();
        entity.setNombre(crearCajaDTO.getNombre());
        entity.setEstado(crearCajaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CajaEntity entity, CrearCajaDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}