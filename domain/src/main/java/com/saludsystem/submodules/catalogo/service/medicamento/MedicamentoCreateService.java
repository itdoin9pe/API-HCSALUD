package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;

public class MedicamentoCreateService
{
	private final MedicamentoRepository medicamentoRepository;

	public MedicamentoCreateService(MedicamentoRepository medicamentoRepository)
	{
		this.medicamentoRepository = medicamentoRepository;
	}

	public Medicamento execute(Medicamento model)
	{
		return medicamentoRepository.save(model);
	}
}