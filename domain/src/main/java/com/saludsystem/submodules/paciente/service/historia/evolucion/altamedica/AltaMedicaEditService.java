package com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica;

import com.saludsystem.submodules.paciente.model.constant.evolucion.AltaMedicaConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;
import com.saludsystem.submodules.paciente.port.dao.evolucion.AltaMedicaDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.AltaMedicaRepository;

public class AltaMedicaEditService
{
	private final AltaMedicaDao altaMedicaDao;
	private final AltaMedicaRepository altaMedicaRepository;

	public AltaMedicaEditService(AltaMedicaDao altaMedicaDao, AltaMedicaRepository altaMedicaRepository)
	{
		this.altaMedicaDao = altaMedicaDao;
		this.altaMedicaRepository = altaMedicaRepository;
	}

	public AltaMedica execute(Long id, AltaMedica altaMedica)
	{
		var currentAltaMedica = altaMedicaDao.getById(id);
		if (currentAltaMedica == null)
		{
			throw new IllegalArgumentException(AltaMedicaConstant.INVALID_ID);
		}
		if (currentAltaMedica.getResumenFinal() != null && currentAltaMedica.getResumenFinal().equals(" "))
		{
			throw new IllegalStateException("El alta medica se encuentra vacias");
		}
		return altaMedicaRepository.update(id, altaMedica);
	}
}
