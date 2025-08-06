package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.Pago;

import java.util.UUID;

public interface PagoRepository {
    Pago save(Pago tipoTarjeta);
    Pago update(UUID uuid, Pago tipoTarjeta);
    void delete(UUID uuid);
}