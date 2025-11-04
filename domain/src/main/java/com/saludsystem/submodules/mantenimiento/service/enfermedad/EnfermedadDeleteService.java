package com.saludsystem.submodules.mantenimiento.service.enfermedad;

import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;
import com.saludsystem.submodules.mantenimiento.port.repository.EnfermedadRepository;

public class EnfermedadDeleteService
{
	private final EnfermedadRepository enfermedadRepository;
	private final EnfermedadDao enfermedadDao;

	public EnfermedadDeleteService(EnfermedadRepository enfermedadRepository, EnfermedadDao enfermedadDao)
	{
		this.enfermedadRepository = enfermedadRepository;
		this.enfermedadDao = enfermedadDao;
	}

	public void execute(String id)
	{
		var enfermedad = enfermedadDao.getById(id);
		if (enfermedad.getEstado() != null && enfermedad.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un tipo de enfermedad ya desactivada");
		}
		enfermedadRepository.delete(id);
	}
}
