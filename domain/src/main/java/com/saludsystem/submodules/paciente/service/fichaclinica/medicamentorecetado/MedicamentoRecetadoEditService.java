package com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.MedicamentoRecetadoConstant;
import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;
import com.saludsystem.submodules.paciente.port.dao.MedicamentoRecetadoDao;
import com.saludsystem.submodules.paciente.port.repository.MedicamentoRecetadoRepository;

public class MedicamentoRecetadoEditService
{
	private final MedicamentoRecetadoDao medicamentoRecetadoDao;
	private final MedicamentoRecetadoRepository medicamentoRecetadoRepository;

	public MedicamentoRecetadoEditService(
		MedicamentoRecetadoDao medicamentoRecetadoDao,
		MedicamentoRecetadoRepository medicamentoRecetadoRepository)
	{
		this.medicamentoRecetadoDao = medicamentoRecetadoDao;
		this.medicamentoRecetadoRepository = medicamentoRecetadoRepository;
	}

	public MedicamentoRecetado execute(UUID uuid, MedicamentoRecetado medicamentoRecetado)
	{
		var currentMedicRecetado = medicamentoRecetadoDao.getById(uuid);
		if (currentMedicRecetado == null)
		{
			throw new IllegalArgumentException(MedicamentoRecetadoConstant.ID_NOT_FOUND);
		}
		if (currentMedicRecetado.getMedicamentoId() != null)
		{
			throw new IllegalStateException("La alergia se encuentra sin un meicamento especifico");
		}
		return medicamentoRecetadoRepository.update(uuid, medicamentoRecetado);
	}
}
