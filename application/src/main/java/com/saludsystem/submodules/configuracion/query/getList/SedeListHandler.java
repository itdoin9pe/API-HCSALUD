package com.saludsystem.submodules.configuracion.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.SedeMapper;
import com.saludsystem.submodules.configuracion.model.Sede;
import com.saludsystem.submodules.configuracion.model.dtos.SedeDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.SedeDao;

@Component
public class SedeListHandler
{
	private final SedeDao sedeDao;
	private final SedeMapper sedeMapper;

	public SedeListHandler(SedeDao sedeDao, SedeMapper sedeMapper)
	{
		this.sedeDao = sedeDao;
		this.sedeMapper = sedeMapper;
	}

	public List<SedeDTO> execute()
	{
		List<Sede> sedeList = sedeDao.getList();
		return sedeList.stream().map(sedeMapper::toDto).toList();
	}
}