package com.saludsystem.domain.paciente.port.in.service.historialclinico.evolucion;

import com.saludsystem.domain.paciente.model.historialclinico.evolucion.AltaMedica;

import java.util.List;
import java.util.UUID;

public interface AltaMedicaService {
    AltaMedica save(AltaMedica altaMedica);
    AltaMedica update(Long id, AltaMedica altaMedica);
    void delete(Long id);
    AltaMedica getById(Long uuid);
    List<AltaMedica> getAll(UUID hospitalId, int page, int rows);
}