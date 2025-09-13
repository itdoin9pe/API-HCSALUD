package com.saludsystem.submodules.catalogo.service.tipoconcepto;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;

public class TipoConceptoDeleteService
{
	private final TipoConceptoRepository tipoConceptoRepository;
	private final TipoConceptoDao tipoConceptoDao;

	public TipoConceptoDeleteService(TipoConceptoRepository tipoConceptoRepository, TipoConceptoDao tipoConceptoDao)
	{
		this.tipoConceptoRepository = tipoConceptoRepository;
		this.tipoConceptoDao = tipoConceptoDao;
	}

	public void execute(UUID uuid)
	{
		var tipoConcepto = tipoConceptoDao.getById(uuid);
		if (tipoConcepto.getEstado() != null && tipoConcepto.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un tipo de concepto ya desactivado");
		}
		tipoConceptoRepository.delete(uuid);
	}
}