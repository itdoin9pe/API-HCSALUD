package com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.DiagnosticoConstant;
import com.saludsystem.submodules.paciente.model.entity.Diagnostico;
import com.saludsystem.submodules.paciente.port.dao.DiagnosticoDao;
import com.saludsystem.submodules.paciente.port.repository.DiagnosticoRepository;

public class DiagnosticoEditService
{
	private final DiagnosticoDao diagnosticoDao;
	private final DiagnosticoRepository diagnosticoRepository;

	public DiagnosticoEditService(DiagnosticoDao diagnosticoDao, DiagnosticoRepository diagnosticoRepository)
	{
		this.diagnosticoDao = diagnosticoDao;
		this.diagnosticoRepository = diagnosticoRepository;
	}

	public Diagnostico execute(UUID uuid, Diagnostico diagnostico)
	{
		var currentDiagnostico = diagnosticoDao.getById(uuid);
		if (currentDiagnostico == null)
		{
			throw new IllegalArgumentException(DiagnosticoConstant.INVALID_ID);
		}
		if (currentDiagnostico.getDescripcion() != null && currentDiagnostico.getDescripcion() == "")
		{
			throw new IllegalStateException("El diagnostico ya se encuentra vacio");
		}
		return diagnosticoRepository.update(uuid, diagnostico);
	}
}
