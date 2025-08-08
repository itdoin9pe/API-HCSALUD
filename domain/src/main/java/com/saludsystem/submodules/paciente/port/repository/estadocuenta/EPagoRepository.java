package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;

import java.util.UUID;

public interface EPagoRepository {
    EPago save(EPago tipoTarjeta);
    EPago update(UUID uuid, EPago tipoTarjeta);
    void delete(UUID uuid);
}