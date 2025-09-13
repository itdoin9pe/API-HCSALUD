package com.saludsystem.submodules.principal.query.getById;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.constant.PaisConstant;
import com.saludsystem.submodules.principal.model.dtos.PaisDTO;
import com.saludsystem.submodules.principal.port.dao.PaisDao;

@Component
public class PaisByIdHandler
{
	private final PaisDao paisDao;
	private final PaisMapper paisMapper;

	public PaisByIdHandler(PaisDao paisDao, PaisMapper paisMapper)
	{
		this.paisDao = paisDao;
		this.paisMapper = paisMapper;
	}

	public PaisDTO execute(Integer id)
	{
		var pais = paisDao.getById(id);
		if (pais == null)
		{
			throw new IllegalArgumentException(PaisConstant.INVALID_ID);
		}
		return paisMapper.toDto(pais);
	}
}