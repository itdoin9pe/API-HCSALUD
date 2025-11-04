package com.saludsystem.submodules.paciente.command.edit.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.CostoHospitalizacionMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.CostoHospitalizacionEditCommand;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion.CostoHospitalizacionEditService;

@Component
public class CostoHospitalizacionEditHandler
{
	private final CostoHospitalizacionEditService costoHospitalizacionEditService;
	private final CostoHospitalizacionMapper costoHospitalizacionMapper;

	public CostoHospitalizacionEditHandler(
		CostoHospitalizacionEditService costoHospitalizacionEditService,
		CostoHospitalizacionMapper costoHospitalizacionMapper)
	{
		this.costoHospitalizacionEditService = costoHospitalizacionEditService;
		this.costoHospitalizacionMapper = costoHospitalizacionMapper;
	}

	public void execute(UUID uuid, CostoHospitalizacionEditCommand editCommand)
	{
		var costoHospitalizacionUpdated = costoHospitalizacionMapper.fromUpdateDto(uuid, editCommand);
		costoHospitalizacionEditService.execute(uuid, costoHospitalizacionUpdated);
	}
}