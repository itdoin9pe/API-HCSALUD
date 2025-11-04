package com.saludsystem.submodules.configuracion.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.model.dtos.UsuarioDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;

@Component
public class UsuarioListHandler
{
	private final UserDao userDao;
	private final UsuarioMapper usuarioMapper;

	public UsuarioListHandler(UserDao userDao, UsuarioMapper usuarioMapper)
	{
		this.userDao = userDao;
		this.usuarioMapper = usuarioMapper;
	}

	public List<UsuarioDTO> execute()
	{
		List<Usuario> usuarioList = userDao.getList();
		return usuarioList.stream().map(usuarioMapper::toDto).toList();
	}
}