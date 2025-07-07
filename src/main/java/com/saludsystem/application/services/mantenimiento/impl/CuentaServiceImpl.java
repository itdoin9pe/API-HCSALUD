package com.saludsystem.application.services.mantenimiento.impl;

import com.saludsystem.application.dtos.mantenimiento.get.CuentaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearCuentaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.mantenimiento.CuentaService;
import com.saludsystem.domain.model.mantenimiento.CuentaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.CuentaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuentaServiceImpl extends GenericServiceImpl<CuentaEntity, CrearCuentaDTO, CuentaDTO, UUID>
        implements CuentaService {

    protected CuentaServiceImpl(
            CuentaRepository cuentaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(cuentaRepository, modelMapper, authValidator, CuentaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearCuentaDTO crearCuentaDTO) {
        return super.save(crearCuentaDTO);
    }

    @Override
    public ListResponse<CuentaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearCuentaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public CuentaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CuentaDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected CuentaEntity convertCreateDtoToEntity(CrearCuentaDTO crearCuentaDTO) {
        CuentaEntity entity = new CuentaEntity();
        entity.setNombre(crearCuentaDTO.getNombre());
        entity.setTotal(crearCuentaDTO.getTotal());
        entity.setEstado(crearCuentaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CuentaEntity entity, CrearCuentaDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getTotal()).ifPresent(entity::setTotal);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}