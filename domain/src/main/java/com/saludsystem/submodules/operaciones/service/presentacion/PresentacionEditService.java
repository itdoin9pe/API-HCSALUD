package com.saludsystem.submodules.operaciones.service.presentacion;

import java.util.UUID;

import com.saludsystem.submodules.operaciones.model.Presentacion;
import com.saludsystem.submodules.operaciones.port.dao.PresentacionDao;
import com.saludsystem.submodules.operaciones.port.repository.PresentacionRepository;

public class PresentacionEditService
{
	private final PresentacionDao presentacionDao;
	private final PresentacionRepository presentacionRepository;

	public PresentacionEditService(PresentacionDao presentacionDao, PresentacionRepository presentacionRepository)
	{
		this.presentacionDao = presentacionDao;
		this.presentacionRepository = presentacionRepository;
	}

	public Presentacion execute(UUID uuid, Presentacion presentacion)
	{
		var currentPresentacion = presentacionDao.getById(uuid);
		if (currentPresentacion.getEstado() != null && currentPresentacion.getEstado() == 0)
		{
			throw new IllegalStateException("La presentacion ya se encuentra desactivada");
		}
		return presentacionRepository.update(uuid, presentacion);
	}
}
