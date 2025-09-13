package com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.CostoTratamientoRepository;

public class CostoTratamientoCreateService
{
	private final CostoTratamientoRepository costoTratamientoRepository;

	public CostoTratamientoCreateService(CostoTratamientoRepository costoTratamientoRepository)
	{
		this.costoTratamientoRepository = costoTratamientoRepository;
	}

	public CostoTratamiento execute(CostoTratamiento costoTratamiento)
	{
		return costoTratamientoRepository.save(costoTratamiento);
	}
}
