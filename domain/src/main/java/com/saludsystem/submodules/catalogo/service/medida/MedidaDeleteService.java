package com.saludsystem.submodules.catalogo.service.medida;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;

public class MedidaDeleteService
{
	private final MedidaRepository medidaRepository;
	private final MedidaDao medidaDao;

	public MedidaDeleteService(MedidaRepository medidaRepository, MedidaDao medidaDao)
	{
		this.medidaRepository = medidaRepository;
		this.medidaDao = medidaDao;
	}

	public void execute(UUID uuid)
	{
		var medida = medidaDao.getById(uuid);
		if (medida.getEstado() != null && medida.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar una medida ya desactivada");
		}
		medidaRepository.delete(uuid);
	}
}