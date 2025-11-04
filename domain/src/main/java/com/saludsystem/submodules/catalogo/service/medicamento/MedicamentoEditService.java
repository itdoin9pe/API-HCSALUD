package com.saludsystem.submodules.catalogo.service.medicamento;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;

public class MedicamentoEditService
{
	private final MedicamentoDao medicamentoDao;
	private final MedicamentoRepository medicamentoRepository;

	public MedicamentoEditService(MedicamentoDao medicamentoDao, MedicamentoRepository medicamentoRepository)
	{
		this.medicamentoDao = medicamentoDao;
		this.medicamentoRepository = medicamentoRepository;
	}

	public Medicamento execute(UUID uuid, Medicamento model)
	{
		var currentMedicamento = medicamentoDao.getById(uuid);
		if (currentMedicamento.getEstado() != null && currentMedicamento.getEstado() == 0)
		{
			throw new IllegalStateException("El medicamento ya se encuentra desactivado");
		}
		currentMedicamento.actualizarNombre(model.getNombre());
		currentMedicamento.actualizarFormaFarmaceutica(model.getFormaFarmaceutica());
		currentMedicamento.actualizarConcentracion(model.getConcentracion());
		currentMedicamento.actualizarConcentracion(model.getContenido());
		currentMedicamento.actualizarEstado(model.getEstado());
		return medicamentoRepository.update(uuid, currentMedicamento);
	}
}