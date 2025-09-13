package com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.estadocuenta.CostoHospitalizacionConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.CostoHospitalizacionDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.CostoHospitalizacionRepository;

public class CostoHospitalizacionEditService
{
	private final CostoHospitalizacionDao costoHospitalizacionDao;
	private final CostoHospitalizacionRepository costoHospitalizacionRepository;

	public CostoHospitalizacionEditService(
		CostoHospitalizacionDao costoHospitalizacionDao,
		CostoHospitalizacionRepository costoHospitalizacionRepository)
	{
		this.costoHospitalizacionDao = costoHospitalizacionDao;
		this.costoHospitalizacionRepository = costoHospitalizacionRepository;
	}

	public CostoHospitalizacion execute(UUID uuid, CostoHospitalizacion costoHospitalizacion)
	{
		var currentCostHospitalizacion = costoHospitalizacionDao.getById(uuid);
		if (currentCostHospitalizacion == null)
		{
			throw new IllegalArgumentException(CostoHospitalizacionConstant.INVALID_ID);
		}
		if (currentCostHospitalizacion.getEstadoCuentaId() != null)
		{
			throw new IllegalStateException("El estado de cuenta no es correcto");
		}
		return costoHospitalizacionRepository.update(uuid, costoHospitalizacion);
	}
}
