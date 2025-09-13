package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;

public class AlergiaCreateService
{
	private final AlergiaRepository alergiaRepository;

	public AlergiaCreateService(AlergiaRepository alergiaRepository)
	{
		this.alergiaRepository = alergiaRepository;
	}

	public Alergia execute(Alergia alergia)
	{
		return alergiaRepository.save(alergia);
	}
}