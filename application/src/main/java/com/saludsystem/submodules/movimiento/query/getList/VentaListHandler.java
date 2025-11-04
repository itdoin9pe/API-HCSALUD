package com.saludsystem.submodules.movimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.VentaMapper;
import com.saludsystem.submodules.movimiento.model.Venta;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDTO;
import com.saludsystem.submodules.movimiento.port.dao.VentaDao;

@Component
public class VentaListHandler
{
	private final VentaDao ventaDao;
	private final VentaMapper ventaMapper;

	public VentaListHandler(VentaDao ventaDao, VentaMapper ventaMapper)
	{
		this.ventaDao = ventaDao;
		this.ventaMapper = ventaMapper;
	}

	public List<VentaDTO> execute()
	{
		List<Venta> ventaList = ventaDao.getList();
		return ventaList.stream().map(ventaMapper::toDto).toList();
	}
}