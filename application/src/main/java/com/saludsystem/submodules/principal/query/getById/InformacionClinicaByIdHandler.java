package com.saludsystem.submodules.principal.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.constant.InformacionClinicaConstant;
import com.saludsystem.submodules.principal.model.dtos.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;

@Component
public class InformacionClinicaByIdHandler
{
	private final InformacionClinicaDao informacionClinicaDao;
	private final InformacionClinicaMapper informacionClinicaMapper;

	public InformacionClinicaByIdHandler(
		InformacionClinicaDao informacionClinicaDao,
		InformacionClinicaMapper informacionClinicaMapper)
	{
		this.informacionClinicaDao = informacionClinicaDao;
		this.informacionClinicaMapper = informacionClinicaMapper;
	}

	public InformacionClinicaDTO execute(UUID uuid)
	{
		var infoClinica = informacionClinicaDao.getById(uuid);
		if (infoClinica == null)
		{
			throw new IllegalArgumentException(InformacionClinicaConstant.INVALID_ID);
		}
		return informacionClinicaMapper.toDto(infoClinica);
	}
}