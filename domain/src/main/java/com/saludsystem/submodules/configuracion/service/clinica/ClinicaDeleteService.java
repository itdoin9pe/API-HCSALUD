package com.saludsystem.submodules.configuracion.service.clinica;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.port.in.dao.SysSaludDao;
import com.saludsystem.submodules.configuracion.port.in.repository.SysSaludRepository;

public class ClinicaDeleteService
{
	private final SysSaludRepository sysSaludRepository;
	private final SysSaludDao sysSaludDao;

	public ClinicaDeleteService(SysSaludRepository sysSaludRepository, SysSaludDao sysSaludDao)
	{
		this.sysSaludRepository = sysSaludRepository;
		this.sysSaludDao = sysSaludDao;
	}

	public void execute(UUID uuid)
	{
		var clinica = sysSaludDao.getById(uuid);
		if (clinica.getEstado() != null && clinica.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar una clinica ya desactivada");
		}
		sysSaludRepository.delete(uuid);
	}
}
