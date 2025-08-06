package com.saludsystem.submodules.paciente.port.dao.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface NotaDao {
    Nota getById(Long id);
    ListResponse<Nota> getAll(UUID hospitalId, int page, int rows);
    List<Nota> getList();
}