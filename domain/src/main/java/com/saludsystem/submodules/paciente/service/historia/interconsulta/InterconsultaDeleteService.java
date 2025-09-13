package com.saludsystem.submodules.paciente.service.historia.interconsulta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InterconsultaDao;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InterconsultaRepository;

public class InterconsultaDeleteService
{
	private final InterconsultaRepository interconsultaRepository;
	private final InterconsultaDao interconsultaDao;

	public InterconsultaDeleteService(
		InterconsultaRepository interconsultaRepository,
		InterconsultaDao interconsultaDao)
	{
		this.interconsultaRepository = interconsultaRepository;
		this.interconsultaDao = interconsultaDao;
	}

	public Interconsulta execute(UUID uuid)
	{
		var interconsulta = interconsultaDao.getById(uuid);
		if (interconsulta.getEstado() != null && interconsulta.getEstado().equals(" "))
		{
			throw new IllegalStateException("No se puede eliminar una interconsulta desactivada");
		}
		return interconsultaRepository.save(interconsulta);
	}
}
