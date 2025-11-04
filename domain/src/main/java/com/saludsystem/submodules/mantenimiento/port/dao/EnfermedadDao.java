package com.saludsystem.submodules.mantenimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.response.ListResponse;

public interface EnfermedadDao
{
	Enfermedad getById(String uuid);

	ListResponse<Enfermedad> getAll(UUID hospitalId, int page, int rows);

	List<Enfermedad> getList();
}