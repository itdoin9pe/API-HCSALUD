package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Mantenimiento.CuentaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CuentaDTO;
import com.saludSystem.domain.model.Mantenimiento.CuentaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.CuentaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuentaServiceImpl extends GenericServiceImpl<CuentaEntity, CuentaDTO,
        UUID, CrearCuentaDTO, ActualizarCuentaDTO> implements CuentaService {

    public CuentaServiceImpl(CuentaRepository cuentaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(cuentaRepository, modelMapper, authValidator, CuentaDTO.class,
                cuentaEntity -> modelMapper.map(cuentaEntity, CuentaDTO.class));
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
    public ApiResponse update(UUID uuid, ActualizarCuentaDTO actualizarCuentaDTO) {
        return super.update(uuid, actualizarCuentaDTO);
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
    protected void updateEntityFromDto(ActualizarCuentaDTO actualizarCuentaDTO, CuentaEntity entity) {
        entity.setNombre(actualizarCuentaDTO.getNombre());
        entity.setTotal(actualizarCuentaDTO.getTotal());
        entity.setEstado(actualizarCuentaDTO.getEstado());
    }
}