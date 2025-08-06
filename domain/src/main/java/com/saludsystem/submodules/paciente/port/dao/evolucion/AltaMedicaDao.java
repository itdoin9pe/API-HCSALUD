package com.saludsystem.submodules.paciente.port.dao.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface AltaMedicaDao {
    AltaMedica getById(Long uuid);
    ListResponse<AltaMedica> getAll(UUID hospitalId, int page, int rows);
    List<AltaMedica> getList();
}