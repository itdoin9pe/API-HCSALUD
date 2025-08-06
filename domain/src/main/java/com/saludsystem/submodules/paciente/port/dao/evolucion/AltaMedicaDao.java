package com.saludsystem.submodules.paciente.port.dao.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;

import java.util.List;
import java.util.UUID;

public interface AltaMedicaDao {
    AltaMedica save(AltaMedica altaMedica);
    AltaMedica update(Long id, AltaMedica altaMedica);
    void delete(Long id);
    AltaMedica getById(Long uuid);
    List<AltaMedica> getAll(UUID hospitalId, int page, int rows);
}