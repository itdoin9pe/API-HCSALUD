package com.saludsystem.submodules.mantenimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.response.ListResponse;

public interface TipoTarjetaDao
{
	TipoTarjeta getById(UUID uuid);

	ListResponse<TipoTarjeta> getAll(UUID hospitalId, int page, int rows);

	List<TipoTarjeta> getList();
}