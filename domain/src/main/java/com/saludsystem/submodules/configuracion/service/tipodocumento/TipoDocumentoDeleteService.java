package com.saludsystem.submodules.configuracion.service.tipodocumento;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.port.in.dao.TipoDocumentoDao;
import com.saludsystem.submodules.configuracion.port.in.repository.TipoDocumentoRepository;

public class TipoDocumentoDeleteService
{
	private final TipoDocumentoRepository tipoDocumentoRepository;
	private final TipoDocumentoDao tipoDocumentoDao;

	public TipoDocumentoDeleteService(
		TipoDocumentoRepository tipoDocumentoRepository,
		TipoDocumentoDao tipoDocumentoDao)
	{
		this.tipoDocumentoRepository = tipoDocumentoRepository;
		this.tipoDocumentoDao = tipoDocumentoDao;
	}

	public void execute(UUID uuid)
	{
		var tipoDoc = tipoDocumentoDao.getById(uuid);
		if (tipoDoc.getEstado() != null && tipoDoc.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un tipo de documento ya desactivado");
		}
		tipoDocumentoRepository.delete(uuid);
	}
}
