package com.saludsystem.submodules.paciente.port.dao.tratamiento;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;
import com.saludsystem.submodules.response.ListResponse;

public interface ProcedimientoDao
{
	Procedimiento getById(UUID uuid);

	ListResponse<Procedimiento> getAll(UUID hospitalId, int page, int rows);

	List<Procedimiento> getList();
}