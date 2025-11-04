package com.saludsystem.submodules.paciente.port.repository.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;

public interface ConsultaRepository
{
	Consulta save(Consulta consulta);

	Consulta update(UUID uuid, Consulta consulta);

	void delete(UUID uuid);
}