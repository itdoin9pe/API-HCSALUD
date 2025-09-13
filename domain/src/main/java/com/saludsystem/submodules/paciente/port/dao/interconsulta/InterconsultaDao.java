package com.saludsystem.submodules.paciente.port.dao.interconsulta;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;
import com.saludsystem.submodules.response.ListResponse;

public interface InterconsultaDao
{
	List<Interconsulta> getList();

	Interconsulta getById(UUID uuid);

	ListResponse<Interconsulta> getAll(UUID hospitalId, int page, int rows);
}
