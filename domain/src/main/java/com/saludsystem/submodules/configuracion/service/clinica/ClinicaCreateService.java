package com.saludsystem.submodules.configuracion.service.clinica;

import com.saludsystem.submodules.configuracion.model.SysSalud;
import com.saludsystem.submodules.configuracion.port.in.repository.SysSaludRepository;

public class ClinicaCreateService
{
	private final SysSaludRepository sysSaludRepository;

	public ClinicaCreateService(SysSaludRepository sysSaludRepository)
	{
		this.sysSaludRepository = sysSaludRepository;
	}

	public SysSalud execute(SysSalud sysSalud)
	{

		return sysSaludRepository.save(sysSalud);

	}
}
