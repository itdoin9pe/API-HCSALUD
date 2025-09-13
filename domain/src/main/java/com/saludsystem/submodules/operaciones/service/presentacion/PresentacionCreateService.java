package com.saludsystem.submodules.operaciones.service.presentacion;

import com.saludsystem.submodules.operaciones.model.Presentacion;
import com.saludsystem.submodules.operaciones.port.repository.PresentacionRepository;

public class PresentacionCreateService
{
	private final PresentacionRepository presentacionRepository;

	public PresentacionCreateService(PresentacionRepository presentacionRepository)
	{
		this.presentacionRepository = presentacionRepository;
	}

	public Presentacion execute(Presentacion presentacion)
	{
		return presentacionRepository.save(presentacion);
	}
}
