package com.saludsystem.submodules.paciente.port.dao.tratamiento;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;
import com.saludsystem.submodules.response.ListResponse;

public interface CostoTratamientoDao
{
	CostoTratamiento getById(UUID uuid);

	ListResponse<CostoTratamiento> getAll(UUID hospitalId, int page, int rows);

	List<CostoTratamiento> getList();
}