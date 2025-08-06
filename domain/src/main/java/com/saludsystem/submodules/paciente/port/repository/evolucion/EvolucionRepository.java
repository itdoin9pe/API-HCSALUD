package com.saludsystem.submodules.paciente.port.repository.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;

import java.util.UUID;

public interface EvolucionRepository {
    Evolucion save(Evolucion evolucion);
    Evolucion update(UUID uuid, Evolucion evolucion);
    void delete(UUID uuid);
}