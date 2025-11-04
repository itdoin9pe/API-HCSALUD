package com.saludsystem.submodules.mantenimiento.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.BancoConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.BancoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;

@Component
public class BancoByIdHandler
{
	private final BancoDao bancoDao;
	private final BancoMapper bancoMapper;

	public BancoByIdHandler(BancoDao bancoDao, BancoMapper bancoMapper)
	{
		this.bancoDao = bancoDao;
		this.bancoMapper = bancoMapper;
	}

	public BancoDTO execute(UUID uuid)
	{
		var banco = bancoDao.getById(uuid);
		if (banco == null)
		{
			throw new IllegalArgumentException(BancoConstant.INVALID_ID);
		}
		return bancoMapper.toDto(banco);
	}
}