package com.saludsystem.domain.paciente.port.in.service.historialclinico.estadocuenta;

import com.saludsystem.domain.paciente.model.historialclinico.estadocuenta.EstadoCuenta;

import java.util.List;
import java.util.UUID;

public interface EstadoCuentaService {
    EstadoCuenta save(EstadoCuenta estadoCuenta);
    EstadoCuenta update(UUID uuid, EstadoCuenta estadoCuenta);
    void delete(UUID uuid);
    EstadoCuenta getById(UUID uuid);
    List<EstadoCuenta> getAll(UUID hospitalId, int page, int rows);
}