package com.saludsystem.submodules.principal.service.tipopaciente;

import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.principal.model.constant.TipoPacienteConstant;
import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;
import com.saludsystem.submodules.principal.port.repository.TipoPacienteRepository;

public class TipoPacienteEditService
{
	private final TipoPacienteDao tipoPacienteDao;
	private final TipoPacienteRepository tipoPacienteRepository;

	public TipoPacienteEditService(TipoPacienteDao tipoPacienteDao, TipoPacienteRepository tipoPacienteRepository)
	{
		this.tipoPacienteDao = tipoPacienteDao;
		this.tipoPacienteRepository = tipoPacienteRepository;
	}

	public TipoPaciente execute(Long id, TipoPaciente tipoPaciente)
	{
		var currentTipoPac = tipoPacienteDao.getById(id);
		if (currentTipoPac == null)
		{
			throw new IllegalArgumentException(TipoPacienteConstant.ID_NOT_FOUND);
		}
		if (currentTipoPac.getNombre() != null && currentTipoPac.getNombre() == "NULL")
		{
			throw new IllegalStateException("El tipo de paciente ya se encuentra desactivado");
		}
		return tipoPacienteRepository.update(id, tipoPaciente);
	}
}
