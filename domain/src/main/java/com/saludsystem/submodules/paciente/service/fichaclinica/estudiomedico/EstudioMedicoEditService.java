package com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico;

import com.saludsystem.submodules.paciente.model.constant.EstudioMedicoConstant;
import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;
import com.saludsystem.submodules.paciente.port.dao.EstudioMedicoDao;
import com.saludsystem.submodules.paciente.port.repository.EstudioMedicoRepository;

public class EstudioMedicoEditService
{
	private final EstudioMedicoDao estudioMedicoDao;
	private final EstudioMedicoRepository estudioMedicoRepository;

	public EstudioMedicoEditService(EstudioMedicoDao estudioMedicoDao, EstudioMedicoRepository estudioMedicoRepository)
	{
		this.estudioMedicoDao = estudioMedicoDao;
		this.estudioMedicoRepository = estudioMedicoRepository;
	}

	public EstudioMedico execute(Long id, EstudioMedico estudioMedico)
	{
		var currentEstudioMedico = estudioMedicoDao.getById(id);
		if (currentEstudioMedico.getId() == null)
		{
			throw new IllegalArgumentException(EstudioMedicoConstant.ID_NOT_FOUND);
		}

		if (currentEstudioMedico.getEstado() != null && currentEstudioMedico.getEstado() == "")
		{
			throw new IllegalStateException("El estudio medico se encuentra vacio");
		}
		return estudioMedicoRepository.update(id, estudioMedico);
	}
}
