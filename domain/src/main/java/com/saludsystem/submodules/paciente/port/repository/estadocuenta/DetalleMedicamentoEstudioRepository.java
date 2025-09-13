package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;

public interface DetalleMedicamentoEstudioRepository
{
	DetalleMedicamentoEstudio save(DetalleMedicamentoEstudio detalleMedicamentoEstudio);

	DetalleMedicamentoEstudio update(UUID uuid, DetalleMedicamentoEstudio detalleMedicamentoEstudio);

	void delete(UUID uuid);
}