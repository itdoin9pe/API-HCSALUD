package com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.port.dao.historialclinico.ConsultaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ConsultaRepository;

public class ConsultaDeleteService
{
	private final ConsultaRepository consultaRepository;
	private final ConsultaDao consultaDao;

	public ConsultaDeleteService(ConsultaRepository consultaRepository, ConsultaDao consultaDao)
	{
		this.consultaRepository = consultaRepository;
		this.consultaDao = consultaDao;
	}

	public void execute(UUID uuid)
	{
		var consulta = consultaDao.getById(uuid);
		if (consulta.getMotivoConsulta() != null && consulta.getDiagnosticoPresuntivo().equals(" "))
		{
			throw new IllegalStateException("No se puede eliminar una consulta sin motiva de consulta");
		}
		consultaRepository.delete(uuid);
	}
}
