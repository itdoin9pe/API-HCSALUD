package com.saludsystem.submodules.paciente.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;
import com.saludsystem.submodules.response.ListResponse;

public interface EstudioResultadoDao
{
	EstudioResultado getById(Long id);

	ListResponse<EstudioResultado> getAll(UUID hospitalId, int page, int rows);

	List<EstudioResultado> getList();
}