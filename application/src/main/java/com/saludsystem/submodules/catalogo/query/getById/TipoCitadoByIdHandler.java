package com.saludsystem.submodules.catalogo.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.constant.TipoCitadoConstant;
import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;

@Component
public class TipoCitadoByIdHandler
{
	private final TipoCitadoDao tipoCitadoDao;
	private final TipoCitadoMapper tipoCitadoMapper;

	public TipoCitadoByIdHandler(TipoCitadoDao tipoCitadoDao, TipoCitadoMapper tipoCitadoMapper)
	{
		this.tipoCitadoDao = tipoCitadoDao;
		this.tipoCitadoMapper = tipoCitadoMapper;
	}

	public TipoCitadoDTO execute(UUID uuid)
	{
		var tipoCitado = tipoCitadoDao.getById(uuid);
		if (tipoCitado == null)
		{
			throw new IllegalArgumentException(TipoCitadoConstant.INVALID_ID);
		}
		return tipoCitadoMapper.toDto(tipoCitado);
	}
}