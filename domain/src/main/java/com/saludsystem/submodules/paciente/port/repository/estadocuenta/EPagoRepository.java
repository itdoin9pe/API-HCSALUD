package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;

import java.util.UUID;

public interface EPagoRepository {
    EPago save(EPago ePago);
    EPago update(UUID uuid, EPago ePago);
    void delete(UUID uuid);
}