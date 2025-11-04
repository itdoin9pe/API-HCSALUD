package com.saludsystem.submodules.principal.port.dao;

import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.response.ListResponse;

public interface InformacionClinicaDao
{
	InformacionClinica getById(UUID uuid);

	ListResponse<InformacionClinica> getAll(UUID hospitalId, int page, int rows);

	List<InformacionClinica> getList();
}