package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;

public class InformacionClinicaCreateService
{
	private final InformacionClinicaRepository informacionClinicaRepository;

	public InformacionClinicaCreateService(InformacionClinicaRepository informacionClinicaRepository)
	{
		this.informacionClinicaRepository = informacionClinicaRepository;
	}

	public InformacionClinica execute(InformacionClinica informacionClinica)
	{
		return informacionClinicaRepository.save(informacionClinica);
	}
}
