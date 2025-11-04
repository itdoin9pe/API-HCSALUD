package com.saludsystem.submodules.principal.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.model.dtos.PaisDTO;
import com.saludsystem.submodules.principal.port.dao.PaisDao;

@Component
public class PaisListHandler
{
	private final PaisDao paisDao;
	private final PaisMapper paisMapper;

	public PaisListHandler(PaisDao paisDao, PaisMapper paisMapper)
	{
		this.paisDao = paisDao;
		this.paisMapper = paisMapper;
	}

	public List<PaisDTO> execute()
	{
		List<Pais> paisList = paisDao.getList();
		return paisList.stream().map(paisMapper::toDto).toList();
	}
}