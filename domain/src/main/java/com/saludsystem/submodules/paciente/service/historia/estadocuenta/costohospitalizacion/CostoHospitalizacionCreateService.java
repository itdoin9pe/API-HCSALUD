package com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.CostoHospitalizacionRepository;

public class CostoHospitalizacionCreateService
{
	private final CostoHospitalizacionRepository costoHospitalizacionRepository;

	public CostoHospitalizacionCreateService(CostoHospitalizacionRepository costoHospitalizacionRepository)
	{
		this.costoHospitalizacionRepository = costoHospitalizacionRepository;
	}

	public CostoHospitalizacion execute(CostoHospitalizacion costoHospitalizacion)
	{
		return costoHospitalizacionRepository.save(costoHospitalizacion);
	}
}
