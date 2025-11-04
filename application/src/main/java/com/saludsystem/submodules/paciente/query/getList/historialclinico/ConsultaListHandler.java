package com.saludsystem.submodules.paciente.query.getList.historialclinico;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ConsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ConsultaDTO;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ConsultaDao;

@Component
public class ConsultaListHandler
{
	private final ConsultaDao consultaDao;
	private final ConsultaMapper consultaMapper;

	public ConsultaListHandler(ConsultaDao consultaDao, ConsultaMapper consultaMapper)
	{
		this.consultaDao = consultaDao;
		this.consultaMapper = consultaMapper;
	}

	public List<ConsultaDTO> execute()
	{
		List<Consulta> consultaList = consultaDao.getList();
		return consultaList.stream().map(consultaMapper::toDto).toList();
	}
}