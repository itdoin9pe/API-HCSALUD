package com.saludsystem.submodules.movimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.CompraMapper;
import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.movimiento.model.dtos.CompraDTO;
import com.saludsystem.submodules.movimiento.port.dao.CompraDao;

@Component
public class CompraListHandler
{
	private final CompraDao compraDao;
	private final CompraMapper compraMapper;

	public CompraListHandler(CompraDao compraDao, CompraMapper compraMapper)
	{
		this.compraDao = compraDao;
		this.compraMapper = compraMapper;
	}

	public List<CompraDTO> execute()
	{
		List<Compra> compraList = compraDao.getList();
		return compraList.stream().map(compraMapper::toDto).toList();
	}
}