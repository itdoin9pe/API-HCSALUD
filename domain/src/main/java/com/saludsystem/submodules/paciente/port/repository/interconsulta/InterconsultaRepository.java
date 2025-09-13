package com.saludsystem.submodules.paciente.port.repository.interconsulta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;

public interface InterconsultaRepository
{
	Interconsulta save(Interconsulta interconsulta);

	Interconsulta update(UUID uuid, Interconsulta interconsulta);

	void execute(UUID uuid);
}