package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;

public interface TipoConceptoRepository
{
	TipoConcepto save(TipoConcepto tipoConcepto);

	TipoConcepto update(UUID uuid, TipoConcepto tipoConcepto);

	void delete(UUID uuid);
}