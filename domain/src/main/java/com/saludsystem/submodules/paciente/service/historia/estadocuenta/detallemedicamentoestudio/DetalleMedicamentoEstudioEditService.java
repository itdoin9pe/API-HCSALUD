package com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.estadocuenta.DetalleMedicamentoEstudioConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.DetalleMedicamentoEstudioDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.DetalleMedicamentoEstudioRepository;

public class DetalleMedicamentoEstudioEditService
{
	private final DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao;
	private final DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository;

	public DetalleMedicamentoEstudioEditService(
		DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao,
		DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository)
	{
		this.detalleMedicamentoEstudioDao = detalleMedicamentoEstudioDao;
		this.detalleMedicamentoEstudioRepository = detalleMedicamentoEstudioRepository;
	}

	public DetalleMedicamentoEstudio execute(UUID uuid, DetalleMedicamentoEstudio detalleMedicamentoEstudio)
	{
		var curretDetMedicEstudio = detalleMedicamentoEstudioDao.getById(uuid);
		if (curretDetMedicEstudio == null)
		{
			throw new IllegalArgumentException(DetalleMedicamentoEstudioConstant.INVALID_ID);
		}
		if (curretDetMedicEstudio.getDescripcion() != null && curretDetMedicEstudio.getDescripcion().equals("EMPTY"))
		{
			throw new IllegalStateException("La descripcion no es correcta");
		}
		return detalleMedicamentoEstudioRepository.update(uuid, detalleMedicamentoEstudio);
	}
}
