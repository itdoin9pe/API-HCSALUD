package com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.MedicamentoRecetadoConstant;
import com.saludsystem.submodules.paciente.port.dao.MedicamentoRecetadoDao;
import com.saludsystem.submodules.paciente.port.repository.MedicamentoRecetadoRepository;

public class MedicamentoRecetadoDeleteService
{
	private final MedicamentoRecetadoRepository medicamentoRecetadoRepository;
	private final MedicamentoRecetadoDao medicamentoRecetadoDao;

	public MedicamentoRecetadoDeleteService(
		MedicamentoRecetadoRepository medicamentoRecetadoRepository,
		MedicamentoRecetadoDao medicamentoRecetadoDao)
	{
		this.medicamentoRecetadoRepository = medicamentoRecetadoRepository;
		this.medicamentoRecetadoDao = medicamentoRecetadoDao;
	}

	public void execute(UUID uuid)
	{
		var medicamentoRecetado = medicamentoRecetadoDao.getById(uuid);
		if (medicamentoRecetado.getId() == null)
		{
			throw new IllegalArgumentException(MedicamentoRecetadoConstant.INVALID_ID);
		}
		medicamentoRecetadoRepository.delete(uuid);
	}
}
