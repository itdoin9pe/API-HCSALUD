package com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.DetalleMedicamentoEstudioRepository;

public class DetalleMedicamentoEstudioCreateService
{
	private final DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository;

	public DetalleMedicamentoEstudioCreateService(
		DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository)
	{
		this.detalleMedicamentoEstudioRepository = detalleMedicamentoEstudioRepository;
	}

	public DetalleMedicamentoEstudio execute(DetalleMedicamentoEstudio detalleMedicamentoEstudio)
	{
		return detalleMedicamentoEstudioRepository.save(detalleMedicamentoEstudio);
	}
}
