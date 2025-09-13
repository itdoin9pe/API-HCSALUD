package com.saludsystem.submodules.principal.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.principal.model.InformacionClinica;

public interface InformacionClinicaRepository
{
	InformacionClinica save(InformacionClinica informacionClinica);

	InformacionClinica update(UUID uuid, InformacionClinica informacionClinica);

	void delete(UUID uuid);
}