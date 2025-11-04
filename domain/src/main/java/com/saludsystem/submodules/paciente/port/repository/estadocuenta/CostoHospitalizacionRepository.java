package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;

public interface CostoHospitalizacionRepository
{
	CostoHospitalizacion save(CostoHospitalizacion costoHospitalizacion);

	CostoHospitalizacion update(UUID uuid, CostoHospitalizacion costoHospitalizacion);

	void delete(UUID uuid);
}