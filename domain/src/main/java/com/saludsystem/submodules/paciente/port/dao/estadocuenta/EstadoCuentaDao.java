package com.saludsystem.submodules.paciente.port.dao.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;

import java.util.List;
import java.util.UUID;

public interface EstadoCuentaDao {
    EstadoCuenta save(EstadoCuenta estadoCuenta);
    EstadoCuenta update(UUID uuid, EstadoCuenta estadoCuenta);
    void delete(UUID uuid);
    EstadoCuenta getById(UUID uuid);
    List<EstadoCuenta> getAll(UUID hospitalId, int page, int rows);
}