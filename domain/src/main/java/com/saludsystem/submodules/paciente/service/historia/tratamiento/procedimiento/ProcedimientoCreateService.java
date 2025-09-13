package com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.ProcedimientoRepository;

public class ProcedimientoCreateService
{
	private final ProcedimientoRepository procedimientoRepository;

	public ProcedimientoCreateService(ProcedimientoRepository procedimientoRepository)
	{
		this.procedimientoRepository = procedimientoRepository;
	}

	public Procedimiento execute(Procedimiento procedimiento)
	{
		return procedimientoRepository.save(procedimiento);
	}
}
