package com.saludsystem.submodules.paciente.port.dao.estadocuenta;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;
import com.saludsystem.submodules.response.ListResponse;

public interface EPagoDao
{
	EPago getById(UUID uuid);

	ListResponse<EPago> getAll(UUID hospitalId, int page, int rows);

	List<EPago> getList();
}