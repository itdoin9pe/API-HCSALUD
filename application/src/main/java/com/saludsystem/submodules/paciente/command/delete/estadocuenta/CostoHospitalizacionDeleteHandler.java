package com.saludsystem.submodules.paciente.command.delete.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion.CostoHospitalizacionDeleteService;

@Component
public class CostoHospitalizacionDeleteHandler
{
	private final CostoHospitalizacionDeleteService costoHospitalizacionDeleteService;

	public CostoHospitalizacionDeleteHandler(CostoHospitalizacionDeleteService costoHospitalizacionDeleteService)
	{
		this.costoHospitalizacionDeleteService = costoHospitalizacionDeleteService;
	}

	public void execute(UUID uuid)
	{
		costoHospitalizacionDeleteService.execute(uuid);
	}
}