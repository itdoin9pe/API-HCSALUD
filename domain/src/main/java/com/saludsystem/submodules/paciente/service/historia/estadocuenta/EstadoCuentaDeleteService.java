package com.saludsystem.submodules.paciente.service.historia.estadocuenta;

import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EstadoCuentaDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EstadoCuentaRepository;

import java.util.UUID;

public class EstadoCuentaDeleteService {

    private final EstadoCuentaRepository estadoCuentaRepository;
    private final EstadoCuentaDao estadoCuentaDao;

    public EstadoCuentaDeleteService(EstadoCuentaRepository estadoCuentaRepository, EstadoCuentaDao estadoCuentaDao) {
        this.estadoCuentaRepository = estadoCuentaRepository;
        this.estadoCuentaDao = estadoCuentaDao;
    }

    public void execute(UUID uuid) {

        var estadoCuenta = estadoCuentaDao.getById(uuid);

        if (estadoCuenta.getEstado() != null && estadoCuenta.getEstado().equals("EMPTY")) {

            throw new IllegalStateException("No se puede eliminar un estado de cuenta EMPTY");

        }

        estadoCuentaRepository.delete(uuid);

    }

}
