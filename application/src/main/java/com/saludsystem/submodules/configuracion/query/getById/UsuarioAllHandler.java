package com.saludsystem.submodules.configuracion.query.getById;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.model.dtos.UsuarioDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class UsuarioAllHandler
{
	private final UserDao userDao;
	private final UsuarioMapper usuarioMapper;

	public UsuarioAllHandler(UserDao userDao, UsuarioMapper usuarioMapper)
	{
		this.userDao = userDao;
		this.usuarioMapper = usuarioMapper;
	}

	public ListResponse<UsuarioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = userDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<UsuarioDTO> data = result.getData().stream().map(usuarioMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}