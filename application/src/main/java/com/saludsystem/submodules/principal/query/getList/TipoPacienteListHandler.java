package com.saludsystem.submodules.principal.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.TipoPacienteMapper;
import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.principal.model.dtos.TipoPacienteDTO;
import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;

@Component
public class TipoPacienteListHandler
{
	private final TipoPacienteDao tipoPacienteDao;
	private final TipoPacienteMapper tipoPacienteMapper;

	public TipoPacienteListHandler(TipoPacienteDao tipoPacienteDao, TipoPacienteMapper tipoPacienteMapper)
	{
		this.tipoPacienteDao = tipoPacienteDao;
		this.tipoPacienteMapper = tipoPacienteMapper;
	}

	public List<TipoPacienteDTO> execute()
	{
		List<TipoPaciente> tipoPacienteList = tipoPacienteDao.getList();
		return tipoPacienteList.stream().map(tipoPacienteMapper::toDto).toList();
	}
}