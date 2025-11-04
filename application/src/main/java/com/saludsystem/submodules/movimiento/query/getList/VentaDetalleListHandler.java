package com.saludsystem.submodules.movimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.VentaDetalleMapper;
import com.saludsystem.submodules.movimiento.model.VentaDetalle;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDetalleDTO;
import com.saludsystem.submodules.movimiento.port.dao.VentaDetalleDao;

@Component
public class VentaDetalleListHandler
{
	private final VentaDetalleDao ventaDetalleDao;
	private final VentaDetalleMapper ventaDetalleMapper;

	/**
	 * @param ventaDetalleDao
	 * @param ventaDetalleMapper
	 */
	public VentaDetalleListHandler(VentaDetalleDao ventaDetalleDao, VentaDetalleMapper ventaDetalleMapper)
	{
		this.ventaDetalleDao = ventaDetalleDao;
		this.ventaDetalleMapper = ventaDetalleMapper;
	}

	public List<VentaDetalleDTO> execute()
	{
		List<VentaDetalle> ventaDList = ventaDetalleDao.getList();
		return ventaDList.stream().map(ventaDetalleMapper::toDto).toList();
	}
}