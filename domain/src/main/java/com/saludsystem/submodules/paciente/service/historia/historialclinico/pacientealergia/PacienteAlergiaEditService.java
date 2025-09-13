package com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.historialclinico.PacienteAlergiaConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.PacienteAlergiaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.PacienteAlergiaRepository;

public class PacienteAlergiaEditService
{
	private final PacienteAlergiaDao pacienteAlergiaDao;
	private final PacienteAlergiaRepository pacienteAlergiaRepository;

	public PacienteAlergiaEditService(
		PacienteAlergiaDao pacienteAlergiaDao,
		PacienteAlergiaRepository pacienteAlergiaRepository)
	{
		this.pacienteAlergiaDao = pacienteAlergiaDao;
		this.pacienteAlergiaRepository = pacienteAlergiaRepository;
	}

	public PacienteAlergia execute(UUID uuid, PacienteAlergia pacienteAlergia)
	{
		var currentPacienteAlergia = pacienteAlergiaDao.getById(uuid);
		if (currentPacienteAlergia == null)
		{
			throw new IllegalStateException(PacienteAlergiaConstant.INVALID_ID);
		}
		if (currentPacienteAlergia.getEstado() != null && currentPacienteAlergia.getEstado() == 0)
		{
			throw new IllegalStateException("La alergia de paciente registrada se encuentra desactivada");
		}
		return pacienteAlergiaRepository.update(uuid, pacienteAlergia);
	}
}
