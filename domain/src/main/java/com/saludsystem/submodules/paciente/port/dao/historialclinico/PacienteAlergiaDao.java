package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PacienteAlergiaDao {
    PacienteAlergia getById(UUID uuid);
    ListResponse<PacienteAlergia> getAll(UUID hospitalId, int page, int rows);
    List<PacienteAlergia> getList();
}