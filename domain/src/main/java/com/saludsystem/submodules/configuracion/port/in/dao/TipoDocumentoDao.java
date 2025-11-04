package com.saludsystem.submodules.configuracion.port.in.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.response.ListResponse;

public interface TipoDocumentoDao
{
	TipoDocumento getById(UUID uuid);

	ListResponse<TipoDocumento> getAll(UUID hospitalId, int page, int rows);

	List<TipoDocumento> getList();
}
