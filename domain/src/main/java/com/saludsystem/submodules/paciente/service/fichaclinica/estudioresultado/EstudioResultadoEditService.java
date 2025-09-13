package com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado;

import com.saludsystem.submodules.paciente.model.constant.EstudioResultadoConstant;
import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;
import com.saludsystem.submodules.paciente.port.dao.EstudioResultadoDao;
import com.saludsystem.submodules.paciente.port.repository.EstudioResultadoRepository;

public class EstudioResultadoEditService
{
	private final EstudioResultadoDao estudioResultadoDao;
	private final EstudioResultadoRepository estudioResultadoRepository;

	public EstudioResultadoEditService(
		EstudioResultadoDao estudioResultadoDao,
		EstudioResultadoRepository estudioResultadoRepository)
	{
		this.estudioResultadoDao = estudioResultadoDao;
		this.estudioResultadoRepository = estudioResultadoRepository;
	}

	public EstudioResultado execute(Long id, EstudioResultado estudioResultado)
	{
		var currenEstudioResultado = estudioResultadoDao.getById(id);
		if (currenEstudioResultado == null)
		{
			throw new IllegalArgumentException(EstudioResultadoConstant.ID_NOT_FOUND);
		}
		if (currenEstudioResultado.getId() != null && currenEstudioResultado.getId() == 0)
		{
			throw new IllegalStateException("El resultado de estudio del paciente es inexistente");
		}
		return estudioResultadoRepository.update(id, estudioResultado);
	}
}
