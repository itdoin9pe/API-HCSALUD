package com.saludsystem.submodules.paciente.query.getList.historialclinico;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.historialclinico.AntecedenteMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.AntecedenteDTO;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.AntecedenteDao;

@Component
public class AntecedenteListHandler
{
	private final AntecedenteDao antecedenteDao;
	private final AntecedenteMapper antecedenteMapper;

	public AntecedenteListHandler(AntecedenteDao antecedenteDao, AntecedenteMapper antecedenteMapper)
	{
		this.antecedenteDao = antecedenteDao;
		this.antecedenteMapper = antecedenteMapper;
	}

	public List<AntecedenteDTO> execute()
	{
		List<Antecedente> antecedenteList = antecedenteDao.getList();
		return antecedenteList.stream().map(antecedenteMapper::toDto).toList();
	}
}