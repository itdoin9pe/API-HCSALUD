package com.saludsystem.submodules.catalogo.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.constant.MedidaConstant;
import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;

@Component
public class MedidaByIdHandler
{
	private final MedidaDao medidaDao;
	private final MedidaMapper medidaMapper;

	public MedidaByIdHandler(MedidaDao medidaDao, MedidaMapper medidaMapper)
	{
		this.medidaDao = medidaDao;
		this.medidaMapper = medidaMapper;
	}

	public MedidaDTO execute(UUID uuid)
	{
		var medida = medidaDao.getById(uuid);
		if (medida == null)
		{
			throw new IllegalArgumentException(MedidaConstant.INVALID_ID);
		}
		return medidaMapper.toDto(medida);
	}
}