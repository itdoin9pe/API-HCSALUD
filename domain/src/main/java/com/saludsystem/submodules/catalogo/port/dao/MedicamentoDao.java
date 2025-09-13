package com.saludsystem.submodules.catalogo.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.response.ListResponse;

public interface MedicamentoDao
{
	Medicamento getById(UUID uuid);

	ListResponse<Medicamento> getAll(UUID hospitalId, int page, int rows);

	List<Medicamento> getList();
}