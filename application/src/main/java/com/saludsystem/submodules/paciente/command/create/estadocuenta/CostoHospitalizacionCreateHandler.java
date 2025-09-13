package com.saludsystem.submodules.paciente.command.create.estadocuenta;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.CostoHospitalizacionMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.CostoHospitalizacionCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion.CostoHospitalizacionCreateService;

@Component
public class CostoHospitalizacionCreateHandler
{
	private final CostoHospitalizacionCreateService costoHospitalizacionCreateService;
	private final CostoHospitalizacionMapper costoHospitalizacionMapper;

	public CostoHospitalizacionCreateHandler(
		CostoHospitalizacionCreateService costoHospitalizacionCreateService,
		CostoHospitalizacionMapper costoHospitalizacionMapper)
	{
		this.costoHospitalizacionCreateService = costoHospitalizacionCreateService;
		this.costoHospitalizacionMapper = costoHospitalizacionMapper;
	}

	public void execute(CostoHospitalizacionCreateCommand createCommand)
	{
		var costHospitalizacionSaved = costoHospitalizacionMapper.fromCreateDto(createCommand);
		costoHospitalizacionCreateService.execute(costHospitalizacionSaved);
	}
}