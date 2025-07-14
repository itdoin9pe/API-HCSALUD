package com.saludsystem.submodules.paciente.port.in.service.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.model.historialclinico.evolucion.Evolucion;


import java.util.List;
import java.util.UUID;

public interface EvolucionService {
    Evolucion save(Evolucion evolucion);
    Evolucion update(UUID uuid, Evolucion evolucion);
    void delete(UUID uuid);
    Evolucion getById(UUID uuid);
    List<Evolucion> getAll(UUID hospitalId, int page, int rows);
}