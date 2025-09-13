package com.saludsystem.submodules.movimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.CompraDetalleMapper;
import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.model.dtos.CompraDetalleDTO;
import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;

@Component
public class CompraDetalleListHandler
{
	private final CompraDetalleDao compraDetalleDao;
	private final CompraDetalleMapper compraDetalleMapper;

	public CompraDetalleListHandler(CompraDetalleDao compraDetalleDao, CompraDetalleMapper compraDetalleMapper)
	{
		this.compraDetalleDao = compraDetalleDao;
		this.compraDetalleMapper = compraDetalleMapper;
	}

	public List<CompraDetalleDTO> execute()
	{
		List<CompraDetalle> compraDetalleList = compraDetalleDao.getList();
		return compraDetalleList.stream().map(compraDetalleMapper::toDto).toList();
	}
}