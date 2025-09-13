package com.saludsystem.submodules.paciente.service.historia.estadocuenta.estadopago;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EPagoRepository;

public class EPagoCreateService
{
	private final EPagoRepository ePagoRepository;

	public EPagoCreateService(EPagoRepository ePagoRepository)
	{
		this.ePagoRepository = ePagoRepository;
	}

	public EPago execute(EPago ePago)
	{
		return ePagoRepository.save(ePago);
	}
}
