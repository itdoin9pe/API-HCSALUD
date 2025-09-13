package com.saludsystem.submodules.catalogo.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;
import com.saludsystem.submodules.response.ListResponse;

public interface TipoConceptoDao
{
	TipoConcepto getById(UUID uuid);

	ListResponse<TipoConcepto> getAll(UUID hospitalId, int page, int rows);

	List<TipoConcepto> getList();
}