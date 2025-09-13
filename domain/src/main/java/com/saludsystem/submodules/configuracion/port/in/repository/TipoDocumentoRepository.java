package com.saludsystem.submodules.configuracion.port.in.repository;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;

public interface TipoDocumentoRepository
{
	TipoDocumento save(TipoDocumento tipoDocumento);

	TipoDocumento update(UUID uuid, TipoDocumento tipoDocumento);

	void delete(UUID uuid);
}