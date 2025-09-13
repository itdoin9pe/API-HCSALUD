package com.saludsystem.submodules.principal.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.response.ListResponse;

public interface EmpresaDao
{
	Empresa getById(UUID uuid);

	ListResponse<Empresa> getAll(UUID hospitalId, int page, int rows);

	List<Empresa> getList();
}