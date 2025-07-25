package com.saludsystem.submodules.paciente.port.dao.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.evolucion.CambioCondicion;

import java.util.List;
import java.util.UUID;

public interface CambioCondicionDao {
    CambioCondicion save(CambioCondicion cambioCondicion);
    CambioCondicion update(Long id, CambioCondicion cambioCondicion);
    void delete(Long id);
    CambioCondicion getById(Long id);
    List<CambioCondicion> getAll(UUID hospitalId, int page, int rows);
}