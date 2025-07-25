package com.saludsystem.submodules.paciente.port.dao.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.estadocuenta.Pago;

import java.util.List;
import java.util.UUID;

public interface PagoDao {
    Pago save(Pago tipoTarjeta);
    Pago update(UUID uuid, Pago tipoTarjeta);
    void delete(UUID uuid);
    Pago getById(UUID uuid);
    List<Pago> getAll(UUID hospitalId, int page, int rows);
}