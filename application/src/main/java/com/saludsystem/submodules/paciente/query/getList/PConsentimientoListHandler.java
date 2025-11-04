package com.saludsystem.submodules.paciente.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.PConsentimientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.PConsentimientoDTO;
import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;
import com.saludsystem.submodules.paciente.port.dao.PConsentimientoDao;

@Component
public class PConsentimientoListHandler
{
	private final PConsentimientoDao pConsentimientoDao;
	private final PConsentimientoMapper pConsentimientoMapper;

	public PConsentimientoListHandler(
		PConsentimientoDao pConsentimientoDao,
		PConsentimientoMapper pConsentimientoMapper)
	{
		this.pConsentimientoDao = pConsentimientoDao;
		this.pConsentimientoMapper = pConsentimientoMapper;
	}

	public List<PConsentimientoDTO> execute()
	{
		List<PacienteConsentimiento> pacienteConsentimientoList = pConsentimientoDao.getList();
		return pacienteConsentimientoList.stream().map(pConsentimientoMapper::toDto).toList();
	}
}