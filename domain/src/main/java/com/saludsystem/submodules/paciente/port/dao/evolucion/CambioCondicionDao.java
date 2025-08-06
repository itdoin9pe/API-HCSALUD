package com.saludsystem.submodules.paciente.port.dao.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface CambioCondicionDao {
    CambioCondicion getById(Long id);
    ListResponse<CambioCondicion> getAll(UUID hospitalId, int page, int rows);
    List<CambioCondicion> getList();
}