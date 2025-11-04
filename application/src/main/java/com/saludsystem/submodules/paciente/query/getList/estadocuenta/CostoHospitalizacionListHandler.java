package com.saludsystem.submodules.paciente.query.getList.estadocuenta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.CostoHospitalizacionMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.CostoHospitalizacionDao;

@Component
public class CostoHospitalizacionListHandler
{
	private final CostoHospitalizacionDao costoHospitalizacionDao;
	private final CostoHospitalizacionMapper costoHospitalizacionMapper;

	public CostoHospitalizacionListHandler(
		CostoHospitalizacionDao costoHospitalizacionDao,
		CostoHospitalizacionMapper costoHospitalizacionMapper)
	{
		this.costoHospitalizacionDao = costoHospitalizacionDao;
		this.costoHospitalizacionMapper = costoHospitalizacionMapper;
	}

	public List<CostoHospitalizacionDTO> execute()
	{
		List<CostoHospitalizacion> costoHospitalizacionList = costoHospitalizacionDao.getList();
		return costoHospitalizacionList.stream().map(costoHospitalizacionMapper::toDto).toList();
	}
}