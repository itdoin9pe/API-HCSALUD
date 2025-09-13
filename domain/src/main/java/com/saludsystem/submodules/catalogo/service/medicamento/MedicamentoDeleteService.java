package com.saludsystem.submodules.catalogo.service.medicamento;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;

public class MedicamentoDeleteService
{
	private final MedicamentoRepository medicamentoRepository;
	private final MedicamentoDao medicamentoDao;

	public MedicamentoDeleteService(MedicamentoRepository medicamentoRepository, MedicamentoDao medicamentoDao)
	{
		this.medicamentoRepository = medicamentoRepository;
		this.medicamentoDao = medicamentoDao;
	}

	public void execute(UUID uuid)
	{
		var medicamento = medicamentoDao.getById(uuid);
		if (medicamento.getEstado() != null && medicamento.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un medicamento ya desactivado");
		}
		medicamentoRepository.delete(uuid);
	}
}