package com.saludsystem.submodules.principal.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.principal.model.dtos.AseguradoraDTO;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;

@Component
public class AseguradoraListHandler
{
	private final AseguradoraDao aseguradoraDao;
	private final AseguradoraMapper aseguradoraMapper;

	public AseguradoraListHandler(AseguradoraDao aseguradoraDao, AseguradoraMapper aseguradoraMapper)
	{
		this.aseguradoraDao = aseguradoraDao;
		this.aseguradoraMapper = aseguradoraMapper;
	}

	public List<AseguradoraDTO> execute()
	{
		List<Aseguradora> aseguradoraList = aseguradoraDao.getList();
		return aseguradoraList.stream().map(aseguradoraMapper::toDto).toList();
	}
}