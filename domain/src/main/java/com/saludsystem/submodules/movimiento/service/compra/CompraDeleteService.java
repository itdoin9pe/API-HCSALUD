package com.saludsystem.submodules.movimiento.service.compra;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.port.dao.CompraDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraRepository;

public class CompraDeleteService
{
	private final CompraRepository compraRepository;
	private final CompraDao compraDao;

	public CompraDeleteService(CompraRepository compraRepository, CompraDao compraDao)
	{
		this.compraRepository = compraRepository;
		this.compraDao = compraDao;
	}

	public void execute(UUID uuid)
	{
		var compra = compraDao.getById(uuid);
		if (compra.getEstado() != null && compra.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar una compra desactivada");
		}
		compraRepository.delete(uuid);
	}
}
