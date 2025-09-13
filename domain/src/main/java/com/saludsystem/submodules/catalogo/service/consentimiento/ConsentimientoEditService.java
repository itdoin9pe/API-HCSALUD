package com.saludsystem.submodules.catalogo.service.consentimiento;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;

public class ConsentimientoEditService
{
	private final ConsentimientoDao consentimientoDao;
	private final ConsentimientoRepository consentimientoRepository;

	public ConsentimientoEditService(
		ConsentimientoDao consentimientoDao,
		ConsentimientoRepository consentimientoRepository)
	{
		this.consentimientoDao = consentimientoDao;
		this.consentimientoRepository = consentimientoRepository;
	}

	public Consentimiento execute(UUID uuid, Consentimiento model)
	{
		var currentConsent = consentimientoDao.getById(uuid);
		if (currentConsent.getEstado() != null && currentConsent.getEstado() == 0)
		{
			throw new IllegalStateException("El consentimiento ya se encuentra desactivado");
		}
		currentConsent.actualizarNombre(model.getNombre());
		currentConsent.actualizarObservacion(model.getObservacion());
		currentConsent.actualizarEstado(model.getEstado());
		currentConsent.actualizarTexto(model.getTexto());
		return consentimientoRepository.update(uuid, currentConsent);
	}
}