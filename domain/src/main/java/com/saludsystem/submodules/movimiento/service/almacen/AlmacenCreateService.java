package com.saludsystem.submodules.movimiento.service.almacen;

import com.saludsystem.submodules.movimiento.model.Almacen;
import com.saludsystem.submodules.movimiento.port.repository.AlmacenRepository;

public class AlmacenCreateService {
	
	private final AlmacenRepository almacenRepository;

	/**
	 * @param almacenRepository
	 */
	public AlmacenCreateService(AlmacenRepository almacenRepository) {
		this.almacenRepository = almacenRepository;
	}
	
	public Almacen execute(Almacen almacen) {
		
		return almacenRepository.save(almacen);
		
	}
	
}
