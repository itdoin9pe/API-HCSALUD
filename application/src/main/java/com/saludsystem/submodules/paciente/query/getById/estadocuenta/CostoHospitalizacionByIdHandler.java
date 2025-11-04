package com.saludsystem.submodules.paciente.query.getById.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.CostoHospitalizacionMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.CostoHospitalizacionConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.CostoHospitalizacionDao;

@Component
public class CostoHospitalizacionByIdHandler
{
	private final CostoHospitalizacionDao costoHospitalizacionDao;
	private final CostoHospitalizacionMapper costoHospitalizacionMapper;

	public CostoHospitalizacionByIdHandler(
		CostoHospitalizacionDao costoHospitalizacionDao,
		CostoHospitalizacionMapper costoHospitalizacionMapper)
	{
		this.costoHospitalizacionDao = costoHospitalizacionDao;
		this.costoHospitalizacionMapper = costoHospitalizacionMapper;
	}

	public CostoHospitalizacionDTO execute(UUID uuid)
	{
		var costoHospitalizacion = costoHospitalizacionDao.getById(uuid);
		if (costoHospitalizacion == null)
		{
			throw new IllegalArgumentException(CostoHospitalizacionConstant.INVALID_ID);
		}
		return costoHospitalizacionMapper.toDto(costoHospitalizacion);
	}
}