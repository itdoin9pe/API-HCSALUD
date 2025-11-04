package com.saludsystem.submodules.catalogo.query.getAll;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.dto.ClienteDTO;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

@Component
public class ClienteAllHandler
{
	private final ClienteDao clienteDao;
	private final ClienteMapper clienteMapper;

	public ClienteAllHandler(ClienteDao clienteDao, ClienteMapper clienteMapper)
	{
		this.clienteDao = clienteDao;
		this.clienteMapper = clienteMapper;
	}

	public ListResponse<ClienteDTO> execute(UUID hospitalId, PaginationRequest paginationRequest)
	{
		var result = clienteDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
		List<ClienteDTO> data = result.getData().stream().map(clienteMapper::toDto).toList();
		return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
	}
}