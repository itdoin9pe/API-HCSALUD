package com.saludsystem.submodules.paciente.service.historia.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EstadoCuentaRepository;

public class EstadoCuentaCreateService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public EstadoCuentaCreateService(EstadoCuentaRepository estadoCuentaRepository) {
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    public EstadoCuenta execute(EstadoCuenta estadoCuenta) {

        return estadoCuentaRepository.save(estadoCuenta);

    }

}
