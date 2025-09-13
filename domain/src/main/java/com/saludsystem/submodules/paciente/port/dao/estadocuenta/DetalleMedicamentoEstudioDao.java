package com.saludsystem.submodules.paciente.port.dao.estadocuenta;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.response.ListResponse;

public interface DetalleMedicamentoEstudioDao
{
	DetalleMedicamentoEstudio getById(UUID uuid);

	ListResponse<DetalleMedicamentoEstudio> getAll(UUID hospitalId, int page, int rows);

	List<DetalleMedicamentoEstudio> getList();
}