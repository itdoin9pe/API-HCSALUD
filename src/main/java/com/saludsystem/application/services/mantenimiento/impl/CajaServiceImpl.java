package com.saludsystem.application.services.mantenimiento.impl;

import com.saludsystem.application.dtos.mantenimiento.get.CajaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearCajaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.mantenimiento.CajaService;
import com.saludsystem.domain.model.mantenimiento.CajaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.CajaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
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