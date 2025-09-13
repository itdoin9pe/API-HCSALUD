package com.saludsystem.submodules.principal.query.getById;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.TipoPacienteMapper;
import com.saludsystem.submodules.principal.model.constant.TipoPacienteConstant;
import com.saludsystem.submodules.principal.model.dtos.TipoPacienteDTO;
import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;

@Component
public class TipoPacienteByIdHandler
{
	private final TipoPacienteDao tipoPacienteDao;
	private final TipoPacienteMapper tipoPacienteMapper;

	public TipoPacienteByIdHandler(TipoPacienteDao tipoPacienteDao, TipoPacienteMapper tipoPacienteMapper)
	{
		this.tipoPacienteDao = tipoPacienteDao;
		this.tipoPacienteMapper = tipoPacienteMapper;
	}

	public TipoPacienteDTO execute(Long id)
	{
		var tipoPac = tipoPacienteDao.getById(id);
		if (tipoPac == null)
		{
			throw new IllegalArgumentException(TipoPacienteConstant.INVALID_ID);
		}
		return tipoPacienteMapper.toDto(tipoPac);
	}
}