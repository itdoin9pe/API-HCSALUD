package com.saludsystem.submodules.paciente.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.PConsentimientoMapper;
import com.saludsystem.submodules.paciente.model.constant.PConsentimientoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.PConsentimientoDTO;
import com.saludsystem.submodules.paciente.port.dao.PConsentimientoDao;

@Component
public class PConsentimientoByIdHandler
{
	private final PConsentimientoDao pConsentimientoDao;
	private final PConsentimientoMapper pConsentimientoMapper;

	public PConsentimientoByIdHandler(
		PConsentimientoDao pConsentimientoDao,
		PConsentimientoMapper pConsentimientoMapper)
	{
		this.pConsentimientoDao = pConsentimientoDao;
		this.pConsentimientoMapper = pConsentimientoMapper;
	}

	public PConsentimientoDTO execute(UUID uuid)
	{
		var pConsentimiento = pConsentimientoDao.getById(uuid);
		if (pConsentimiento == null)
		{
			throw new IllegalArgumentException(PConsentimientoConstant.INVALID_ID);
		}
		return pConsentimientoMapper.toDto(pConsentimiento);
	}
}