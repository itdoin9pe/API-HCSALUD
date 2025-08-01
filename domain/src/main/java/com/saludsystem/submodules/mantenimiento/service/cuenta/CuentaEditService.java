package com.saludsystem.submodules.mantenimiento.service.cuenta;

import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.CuentaRepository;

import java.util.UUID;

public class CuentaEditService {

    private final CuentaDao cuentaDao;
    private final CuentaRepository cuentaRepository;

    public CuentaEditService(CuentaDao cuentaDao, CuentaRepository cuentaRepository) {
        this.cuentaDao = cuentaDao;
        this.cuentaRepository = cuentaRepository;
    }

    public Cuenta execute(UUID uuid, Cuenta cuenta) {

        var currentCuenta = cuentaDao.getById(uuid);

        if (currentCuenta.getEstado() != null && currentCuenta.getEstado() == 0) {

            throw new IllegalStateException("El tipo de cuenta ya se encuentra desactivada");

        }

        return cuentaRepository.update(uuid, cuenta);

    }

}
