package com.saludsystem.submodules.paciente.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.Diagnostico;
import com.saludsystem.submodules.response.ListResponse;

public interface DiagnosticoDao
{
	Diagnostico getById(UUID uuid);

	ListResponse<Diagnostico> getAll(UUID hospitalId, int page, int rows);

	List<Diagnostico> getList();
}