package com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico;

import java.util.UUID;

import com.saludsystem.submodules.paciente.port.dao.DiagnosticoDao;
import com.saludsystem.submodules.paciente.port.repository.DiagnosticoRepository;

public class DiagnosticoDeleteService
{
	private final DiagnosticoRepository diagnosticoRepository;
	private final DiagnosticoDao diagnosticoDao;

	public DiagnosticoDeleteService(DiagnosticoRepository diagnosticoRepository, DiagnosticoDao diagnosticoDao)
	{
		this.diagnosticoRepository = diagnosticoRepository;
		this.diagnosticoDao = diagnosticoDao;
	}

	public void execute(UUID uuid)
	{
		var diagnostico = diagnosticoDao.getById(uuid);
		if (diagnostico.getDescripcion() != null && diagnostico.getDescripcion() == "")
		{
			throw new IllegalStateException("No se puede eliminar un diagnostico sin descripcion");
		}
		diagnosticoRepository.delete(uuid);
	}
}
