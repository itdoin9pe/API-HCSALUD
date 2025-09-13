package com.saludsystem.submodules.paciente.port.dao.evolucion;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Evolucion;
import com.saludsystem.submodules.response.ListResponse;

public interface EvolucionDao
{
	Evolucion getById(UUID uuid);

	ListResponse<Evolucion> getAll(UUID hospitalId, int page, int rows);

	List<Evolucion> getList();
}