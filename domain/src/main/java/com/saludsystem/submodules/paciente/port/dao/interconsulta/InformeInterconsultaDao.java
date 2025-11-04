package com.saludsystem.submodules.paciente.port.dao.interconsulta;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;
import com.saludsystem.submodules.response.ListResponse;

public interface InformeInterconsultaDao
{
	List<InformeInterconsulta> getList();

	InformeInterconsulta getById(UUID uuid);

	ListResponse<InformeInterconsulta> getAll(UUID hospitalId, int page, int rows);
}
