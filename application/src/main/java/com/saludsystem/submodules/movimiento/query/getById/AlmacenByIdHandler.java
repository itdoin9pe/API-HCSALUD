package com.saludsystem.submodules.movimiento.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.AlmacenMapper;
import com.saludsystem.submodules.movimiento.model.constant.AlmacenConstant;
import com.saludsystem.submodules.movimiento.model.dtos.AlmacenDTO;
import com.saludsystem.submodules.movimiento.port.dao.AlmacenDao;

@Component
public class AlmacenByIdHandler {

	private final AlmacenDao almacenDao;
	private final AlmacenMapper almacenMapper;
	
	/**
	 * @param almacenDao
	 * @param almacenMapper
	 */
	public AlmacenByIdHandler(AlmacenDao almacenDao, AlmacenMapper almacenMapper) {
		this.almacenDao = almacenDao;
		this.almacenMapper = almacenMapper;
	}
	
	public AlmacenDTO execute(UUID uuid) {
		
		var almacen = almacenDao.getById(uuid);
		
		if (almacen == null) {
			throw new IllegalArgumentException(AlmacenConstant.ID_NOT_FOUND);
		}
		
		return almacenMapper.toDto(almacen);
		
	}

}
