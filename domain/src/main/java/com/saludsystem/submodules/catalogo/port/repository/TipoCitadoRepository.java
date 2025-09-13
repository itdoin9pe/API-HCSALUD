package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.TipoCitado;

public interface TipoCitadoRepository
{
	TipoCitado save(TipoCitado tipoCitado);

	TipoCitado update(UUID uuid, TipoCitado tipoCitado);

	void delete(UUID uuid);
}