package com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico;

import com.saludsystem.submodules.paciente.port.dao.EstudioMedicoDao;
import com.saludsystem.submodules.paciente.port.repository.EstudioMedicoRepository;

public class EstudioMedicoDeleteService
{
	private final EstudioMedicoRepository estudioMedicoRepository;
	private final EstudioMedicoDao estudioMedicoDao;

	public EstudioMedicoDeleteService(
		EstudioMedicoRepository estudioMedicoRepository,
		EstudioMedicoDao estudioMedicoDao)
	{
		this.estudioMedicoRepository = estudioMedicoRepository;
		this.estudioMedicoDao = estudioMedicoDao;
	}

	public void execute(Long id)
	{
		var estudioMedico = estudioMedicoDao.getById(id);
		if (estudioMedico.getId() != null && estudioMedico.getId() == 0)
		{
			throw new IllegalArgumentException("No se puede eliminiar un estudio medico inexistente");
		}
		estudioMedicoRepository.delete(id);
	}
}
