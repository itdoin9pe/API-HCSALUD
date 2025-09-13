package com.saludsystem.submodules.principal.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.response.ListResponse;

public interface EstudioDao
{
	Estudio getById(UUID uuid);

	ListResponse<Estudio> getAll(UUID hospitalId, int page, int rows);

	List<Estudio> getList();
}