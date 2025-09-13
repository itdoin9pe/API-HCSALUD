package com.saludsystem.submodules.mantenimiento.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.response.ListResponse;

public interface TipoPagoDao
{
	TipoPago getById(UUID uuid);

	ListResponse<TipoPago> getAll(UUID hospitalId, int page, int rows);

	List<TipoPago> getList();
}