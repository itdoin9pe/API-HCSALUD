package com.saludsystem.submodules.paciente.port.repository.interconsulta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;

public interface InformeInterconsultaRepository
{
	InformeInterconsulta save(InformeInterconsulta informeInterconsulta);

	InformeInterconsulta update(UUID uuid, InformeInterconsulta informeInterconsulta);

	void delete(UUID uuid);
}
