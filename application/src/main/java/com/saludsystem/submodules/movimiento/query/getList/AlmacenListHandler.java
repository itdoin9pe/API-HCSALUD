package com.saludsystem.submodules.movimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.AlmacenMapper;
import com.saludsystem.submodules.movimiento.model.Almacen;
import com.saludsystem.submodules.movimiento.model.dtos.AlmacenDTO;
import com.saludsystem.submodules.movimiento.port.dao.AlmacenDao;

@Component
public class AlmacenListHandler {
	
	private final AlmacenDao almacenDao;
	private final AlmacenMapper almacenMapper;
	
	/**
	 * @param almacenDao
	 * @param almacenMapper
	 */
	public AlmacenListHandler(AlmacenDao almacenDao, AlmacenMapper almacenMapper) {
		this.almacenDao = almacenDao;
		this.almacenMapper = almacenMapper;
	}
	
	public List<AlmacenDTO> execute() {
		
		List<Almacen> almacenList = almacenDao.getList();
		
		return almacenList.stream()
				.map(almacenMapper::toDto)
				.toList();
		
	}
	
}
