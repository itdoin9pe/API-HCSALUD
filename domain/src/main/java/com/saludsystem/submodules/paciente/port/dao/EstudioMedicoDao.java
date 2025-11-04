package com.saludsystem.submodules.paciente.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;
import com.saludsystem.submodules.response.ListResponse;

public interface EstudioMedicoDao
{
	EstudioMedico getById(Long id);

	ListResponse<EstudioMedico> getAll(UUID hospitalId, int page, int rows);

	List<EstudioMedico> getList();
}