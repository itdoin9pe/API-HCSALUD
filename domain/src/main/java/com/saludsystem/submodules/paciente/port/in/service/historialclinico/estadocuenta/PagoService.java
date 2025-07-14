package com.saludsystem.submodules.paciente.port.in.service.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.model.historialclinico.estadocuenta.Pago;

import java.util.List;
import java.util.UUID;

public interface PagoService {
    Pago save(Pago tipoTarjeta);
    Pago update(UUID uuid, Pago tipoTarjeta);
    void delete(UUID uuid);
    Pago getById(UUID uuid);
    List<Pago> getAll(UUID hospitalId, int page, int rows);
}