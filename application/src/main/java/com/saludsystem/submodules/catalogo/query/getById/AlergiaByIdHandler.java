package com.saludsystem.submodules.catalogo.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.constant.AlergiaConstant;
import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;

/**
 * The type Alergia by id handler.
 */
@Component
public class AlergiaByIdHandler
{
	private final AlergiaDao alergiaDao;
	private final AlergiaMapper alergiaMapper;

	public AlergiaByIdHandler(AlergiaDao alergiaDao, AlergiaMapper alergiaMapper)
	{
		this.alergiaDao = alergiaDao;
		this.alergiaMapper = alergiaMapper;
	}

	public AlergiaDTO execute(UUID id)
	{
		var alergia = alergiaDao.getById(id);
		if (alergia == null)
		{
			throw new IllegalArgumentException(AlergiaConstant.INVALID_ID);
		}
		return alergiaMapper.toDto(alergia);
	}
}