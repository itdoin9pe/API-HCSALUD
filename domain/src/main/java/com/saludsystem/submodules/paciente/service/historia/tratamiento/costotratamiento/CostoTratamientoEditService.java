package com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.tratamiento.CostoTratamientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.CostoTratamientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.CostoTratamientoRepository;

public class CostoTratamientoEditService
{
	private final CostoTratamientoDao costoTratamientoDao;
	private final CostoTratamientoRepository costoTratamientoRepository;

	public CostoTratamientoEditService(
		CostoTratamientoDao costoTratamientoDao,
		CostoTratamientoRepository costoTratamientoRepository)
	{
		this.costoTratamientoDao = costoTratamientoDao;
		this.costoTratamientoRepository = costoTratamientoRepository;
	}

	public CostoTratamiento execute(UUID uuid, CostoTratamiento costoTratamiento)
	{
		var currentCostoTratamiento = costoTratamientoDao.getById(uuid);
		if (currentCostoTratamiento == null)
		{
			throw new IllegalArgumentException(CostoTratamientoConstant.INVALID_ID);
		}
		if (currentCostoTratamiento.getConcepto() != null && currentCostoTratamiento.getConcepto().equals(" "))
		{
			throw new IllegalStateException("El concepto del costo no puede estar vacio");
		}
		return costoTratamientoRepository.update(uuid, costoTratamiento);
	}
}
