package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;
import com.saludsystem.submodules.response.ListResponse;

public interface PacienteAlergiaDao
{
	PacienteAlergia getById(UUID uuid);

	ListResponse<PacienteAlergia> getAll(UUID hospitalId, int page, int rows);

	List<PacienteAlergia> getList();
}