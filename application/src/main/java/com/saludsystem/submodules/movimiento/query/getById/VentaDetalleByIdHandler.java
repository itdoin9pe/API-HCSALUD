package com.saludsystem.submodules.movimiento.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.VentaDetalleMapper;
import com.saludsystem.submodules.movimiento.model.constant.VentaDetalleConstant;
import com.saludsystem.submodules.movimiento.model.dtos.VentaDetalleDTO;
import com.saludsystem.submodules.movimiento.port.dao.VentaDetalleDao;

@Component
public class VentaDetalleByIdHandler {

	private final VentaDetalleDao ventaDetalleDao;
	private final VentaDetalleMapper ventaDetalleMapper;
	
	/**
	 * @param ventaDetalleDao
	 * @param ventaDetalleMapper
	 */
	public VentaDetalleByIdHandler(VentaDetalleDao ventaDetalleDao, VentaDetalleMapper ventaDetalleMapper) {
		this.ventaDetalleDao = ventaDetalleDao;
		this.ventaDetalleMapper = ventaDetalleMapper;
	}
	
	public VentaDetalleDTO execute(UUID uuid) {
		var ventaDet = ventaDetalleDao.getById(uuid);
		if (ventaDet == null) {
			throw new IllegalArgumentException(VentaDetalleConstant.INVALID_ID);
		}
		return ventaDetalleMapper.toDto(ventaDet);
	}

}
