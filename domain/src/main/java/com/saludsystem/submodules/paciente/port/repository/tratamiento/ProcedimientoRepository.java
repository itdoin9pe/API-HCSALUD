package com.saludsystem.submodules.paciente.port.repository.tratamiento;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;

public interface ProcedimientoRepository
{
	Procedimiento save(Procedimiento procedimiento);

	Procedimiento update(UUID uuid, Procedimiento procedimiento);

	void delete(UUID uuid);
}