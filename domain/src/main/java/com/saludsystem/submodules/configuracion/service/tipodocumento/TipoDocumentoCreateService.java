package com.saludsystem.submodules.configuracion.service.tipodocumento;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.configuracion.port.in.repository.TipoDocumentoRepository;

public class TipoDocumentoCreateService
{
	private final TipoDocumentoRepository tipoDocumentoRepository;

	public TipoDocumentoCreateService(TipoDocumentoRepository tipoDocumentoRepository)
	{
		this.tipoDocumentoRepository = tipoDocumentoRepository;
	}

	public TipoDocumento execute(TipoDocumento tipoDocumento)
	{
		return tipoDocumentoRepository.save(tipoDocumento);
	}
}
