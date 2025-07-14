package com.saludsystem.submodules.paciente.port.in.service.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.model.historialclinico.evolucion.CambioCondicion;

import java.util.List;
import java.util.UUID;

public interface CambioCondicionService {
    CambioCondicion save(CambioCondicion cambioCondicion);
    CambioCondicion update(Long id, CambioCondicion cambioCondicion);
    void delete(Long id);
    CambioCondicion getById(Long id);
    List<CambioCondicion> getAll(UUID hospitalId, int page, int rows);
}