package com.saludsystem.submodules.catalogo.service.tipocitado;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;

public class TipoCitadoDeleteService
{
	private final TipoCitadoRepository tipoCitadoRepository;
	private final TipoCitadoDao tipoCitadoDao;

	public TipoCitadoDeleteService(TipoCitadoRepository tipoCitadoRepository, TipoCitadoDao tipoCitadoDao)
	{
		this.tipoCitadoRepository = tipoCitadoRepository;
		this.tipoCitadoDao = tipoCitadoDao;
	}

	public void execute(UUID uuid)
	{
		var tipoCitado = tipoCitadoDao.getById(uuid);
		if (tipoCitado.getEstado() != null && tipoCitado.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un tipo de citado ya desactivado");
		}
		tipoCitadoRepository.delete(uuid);
	}
}