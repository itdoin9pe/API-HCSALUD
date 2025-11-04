package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;

public class EspecialidadCreateService
{
	private final EspecialidadRepository especialidadRepository;

	public EspecialidadCreateService(EspecialidadRepository especialidadRepository)
	{
		this.especialidadRepository = especialidadRepository;
	}

	public Especialidad execute(Especialidad model)
	{
		return especialidadRepository.save(model);
	}
}