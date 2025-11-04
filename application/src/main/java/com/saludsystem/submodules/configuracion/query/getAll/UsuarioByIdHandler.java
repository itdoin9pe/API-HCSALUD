package com.saludsystem.submodules.configuracion.query.getAll;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.model.constant.UserConstant;
import com.saludsystem.submodules.configuracion.model.dtos.UsuarioDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;

@Component
public class UsuarioByIdHandler
{
	private final UserDao userDao;
	private final UsuarioMapper usuarioMapper;

	public UsuarioByIdHandler(UserDao userDao, UsuarioMapper usuarioMapper)
	{
		this.userDao = userDao;
		this.usuarioMapper = usuarioMapper;
	}

	public UsuarioDTO execute(UUID uuid)
	{
		var usuario = userDao.getById(uuid);
		if (usuario == null)
		{
			throw new IllegalArgumentException(UserConstant.ID_NOT_FOUND);
		}
		return usuarioMapper.toDto(usuario);
	}
}