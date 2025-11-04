package com.saludsystem.submodules.paciente.port.dao.evolucion;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;
import com.saludsystem.submodules.response.ListResponse;

public interface AltaMedicaDao
{
	AltaMedica getById(Long id);

	ListResponse<AltaMedica> getAll(UUID hospitalId, int page, int rows);

	List<AltaMedica> getList();
}