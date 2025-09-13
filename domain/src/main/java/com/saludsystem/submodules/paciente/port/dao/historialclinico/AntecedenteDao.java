package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;
import com.saludsystem.submodules.response.ListResponse;

public interface AntecedenteDao
{
	Antecedente getById(UUID uuid);

	ListResponse<Antecedente> getAll(UUID hospitalId, int page, int rows);

	List<Antecedente> getList();
}