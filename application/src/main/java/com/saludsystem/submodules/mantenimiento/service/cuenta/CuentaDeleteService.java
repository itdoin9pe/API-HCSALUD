package com.saludsystem.submodules.mantenimiento.service.cuenta;

import com.saludsystem.submodules.mantenimiento.port.repository.CuentaRepository;

import java.util.UUID;

public class CuentaDeleteService {

    private final CuentaRepository cuentaRepository;

    public CuentaDeleteService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public void execute(UUID uuid) {
        cuentaRepository.delete(uuid);
    }
}
