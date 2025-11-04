package com.saludsystem.submodules.principal.service.tipopaciente;

import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;
import com.saludsystem.submodules.principal.port.repository.TipoPacienteRepository;

public class TipoPacienteDeleteService
{
	private final TipoPacienteRepository tipoPacienteRepository;
	private final TipoPacienteDao tipoPacienteDao;

	public TipoPacienteDeleteService(TipoPacienteRepository tipoPacienteRepository, TipoPacienteDao tipoPacienteDao)
	{
		this.tipoPacienteRepository = tipoPacienteRepository;
		this.tipoPacienteDao = tipoPacienteDao;
	}

	public void execute(Long id)
	{
		var tipoPaciente = tipoPacienteDao.getById(id);
		if (tipoPaciente.getNombre() != null && tipoPaciente.getNombre() == "NULL")
		{
			throw new IllegalStateException("No se puede eliminar un tipo de paciente ya desactivada");
		}
		tipoPacienteRepository.delete(id);
	}
}
