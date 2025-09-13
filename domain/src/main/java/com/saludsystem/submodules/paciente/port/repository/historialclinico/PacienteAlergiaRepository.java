package com.saludsystem.submodules.paciente.port.repository.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;

public interface PacienteAlergiaRepository
{
	PacienteAlergia save(PacienteAlergia pacienteAlergia);

	PacienteAlergia update(UUID uuid, PacienteAlergia pacienteAlergia);

	void delete(UUID uuid);
}