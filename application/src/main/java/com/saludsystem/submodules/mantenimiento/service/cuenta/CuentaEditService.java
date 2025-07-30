package com.saludsystem.submodules.mantenimiento.service.cuenta;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.mantenimiento.dtos.put.ActualizarCuentaDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.CuentaRepository;

import java.util.UUID;

public class CuentaEditService {

    private final CuentaRepository cuentaRepository;

    public CuentaEditService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public Cuenta execute(UUID uuid, ActualizarCuentaDTO dto) {

        var updateToSave = CuentaMapper.fromUpdateDto(uuid, dto);

        return cuentaRepository.update(uuid, updateToSave);

    }
}
