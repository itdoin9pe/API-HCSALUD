package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;

import java.util.UUID;

public interface EstadoCuentaRepository {
    EstadoCuenta save(EstadoCuenta estadoCuenta);
    EstadoCuenta update(UUID uuid, EstadoCuenta estadoCuenta);
    void delete(UUID uuid);
}