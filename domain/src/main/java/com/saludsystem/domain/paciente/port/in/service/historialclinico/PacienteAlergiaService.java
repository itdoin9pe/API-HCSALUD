package com.saludsystem.domain.paciente.port.in.service.historialclinico;

import com.saludsystem.domain.paciente.model.historialclinico.PacienteAlergia;

import java.util.List;
import java.util.UUID;

public interface PacienteAlergiaService {
    PacienteAlergia save(PacienteAlergia pacienteAlergia);
    PacienteAlergia update(UUID uuid, PacienteAlergia pacienteAlergia);
    void delete(UUID uuid);
    PacienteAlergia getById(UUID uuid);
    List<PacienteAlergia> getAll(UUID hospitalId, int page, int rows);
}