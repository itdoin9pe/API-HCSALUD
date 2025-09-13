package com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.interconsulta.InformeInterconsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InformeInterconsultaDao;
import com.saludsystem.submodules.paciente.port.repository.interconsulta.InformeInterconsultaRepository;

public class InformeInterEditService
{
	private final InformeInterconsultaDao informeInterconsultaDao;
	private final InformeInterconsultaRepository informeInterconsultaRepository;

	public InformeInterEditService(
		InformeInterconsultaDao informeInterconsultaDao,
		InformeInterconsultaRepository informeInterconsultaRepository)
	{
		this.informeInterconsultaDao = informeInterconsultaDao;
		this.informeInterconsultaRepository = informeInterconsultaRepository;
	}

	public InformeInterconsulta execute(UUID uuid, InformeInterconsulta informeInterconsulta)
	{
		var currenInformInterm = informeInterconsultaDao.getById(uuid);
		if (currenInformInterm == null)
		{
			throw new IllegalArgumentException(InformeInterconsultaConstant.INVALID_ID);
		}
		if (currenInformInterm.getDiagnostico() != null && currenInformInterm.getDiagnostico().equals(" "))
		{
			throw new IllegalStateException("Diagnostico sin detallar o vacio");
		}
		return informeInterconsultaRepository.update(uuid, informeInterconsulta);
	}
}
