package com.saludsystem.submodules.paciente.port.repository.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;

import java.util.UUID;

public interface PacienteAlergiaRepository {
    PacienteAlergia save(PacienteAlergia pacienteAlergia);
    PacienteAlergia update(UUID uuid, PacienteAlergia pacienteAlergia);
    void delete(UUID uuid);
}