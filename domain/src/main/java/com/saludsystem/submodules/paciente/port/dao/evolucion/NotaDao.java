package com.saludsystem.submodules.paciente.port.dao.evolucion;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;
import com.saludsystem.submodules.response.ListResponse;

public interface NotaDao
{
	Nota getById(Long id);

	ListResponse<Nota> getAll(UUID hospitalId, int page, int rows);

	List<Nota> getList();
}