package com.saludsystem.submodules.paciente.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.RecetaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.RecetaDTO;
import com.saludsystem.submodules.paciente.model.entity.Receta;
import com.saludsystem.submodules.paciente.port.dao.RecetaDao;

@Component
public class RecetaListHandler
{
	private final RecetaDao recetaDao;
	private final RecetaMapper recetaMapper;

	public RecetaListHandler(RecetaDao recetaDao, RecetaMapper recetaMapper)
	{
		this.recetaDao = recetaDao;
		this.recetaMapper = recetaMapper;
	}

	public List<RecetaDTO> execute()
	{
		List<Receta> recetaList = recetaDao.getList();
		return recetaList.stream().map(recetaMapper::toDto).toList();
	}
}