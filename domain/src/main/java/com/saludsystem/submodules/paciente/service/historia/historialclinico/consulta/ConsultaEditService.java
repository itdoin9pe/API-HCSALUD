package com.saludsystem.submodules.paciente.service.historia.historialclinico.consulta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.historialclinico.ConsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ConsultaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.ConsultaRepository;

public class ConsultaEditService
{
	private final ConsultaDao consultaDao;
	private final ConsultaRepository consultaRepository;

	public ConsultaEditService(ConsultaDao consultaDao, ConsultaRepository consultaRepository)
	{
		this.consultaDao = consultaDao;
		this.consultaRepository = consultaRepository;
	}

	public Consulta execute(UUID uuid, Consulta consulta)
	{
		var currentConsulta = consultaDao.getById(uuid);
		if (currentConsulta == null)
		{
			throw new IllegalArgumentException(ConsultaConstant.INVALID_ID);
		}

		if (currentConsulta.getMotivoConsulta() != null && currentConsulta.getMotivoConsulta().equals(" "))
		{
			throw new IllegalStateException("El motivo de consulta esta vacia");
		}
		return consultaRepository.update(uuid, consulta);
	}
}
