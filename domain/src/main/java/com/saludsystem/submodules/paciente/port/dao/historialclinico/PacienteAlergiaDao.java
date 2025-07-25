package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;

import java.util.List;
import java.util.UUID;

public interface PacienteAlergiaDao {
    PacienteAlergia save(PacienteAlergia pacienteAlergia);
    PacienteAlergia update(UUID uuid, PacienteAlergia pacienteAlergia);
    void delete(UUID uuid);
    PacienteAlergia getById(UUID uuid);
    List<PacienteAlergia> getAll(UUID hospitalId, int page, int rows);
}