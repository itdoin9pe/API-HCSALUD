package com.saludsystem.submodules.movimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.InventarioMapper;
import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.movimiento.model.dtos.InventarioDTO;
import com.saludsystem.submodules.movimiento.port.dao.InventarioDao;

@Component
public class InventarioListHandler {
	
	private final InventarioDao inventarioDao;
	private final InventarioMapper inventarioMapper;
	
	/**
	 * @param inventarioDao
	 * @param inventarioMapper
	 */
	public InventarioListHandler(InventarioDao inventarioDao, InventarioMapper inventarioMapper) {
		this.inventarioDao = inventarioDao;
		this.inventarioMapper = inventarioMapper;
	}
	
	public List<InventarioDTO> execute() {
		List<Inventario> inventarioList = inventarioDao.getList();
		return inventarioList.stream()
				.map(inventarioMapper::toDto)
				.toList();
	}
	
}