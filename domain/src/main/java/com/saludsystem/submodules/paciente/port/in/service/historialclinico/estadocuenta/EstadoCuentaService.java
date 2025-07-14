package com.saludsystem.submodules.paciente.port.in.service.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.model.historialclinico.estadocuenta.EstadoCuenta;

import java.util.List;
import java.util.UUID;

public interface EstadoCuentaService {
    EstadoCuenta save(EstadoCuenta estadoCuenta);
    EstadoCuenta update(UUID uuid, EstadoCuenta estadoCuenta);
    void delete(UUID uuid);
    EstadoCuenta getById(UUID uuid);
    List<EstadoCuenta> getAll(UUID hospitalId, int page, int rows);
}