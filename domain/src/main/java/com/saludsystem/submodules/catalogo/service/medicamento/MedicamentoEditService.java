package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;

import java.util.UUID;

public class MedicamentoEditService {

    private final MedicamentoDao medicamentoDao;
    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoEditService(MedicamentoDao medicamentoDao, MedicamentoRepository medicamentoRepository) {
        this.medicamentoDao = medicamentoDao;
        this.medicamentoRepository = medicamentoRepository;
    }

    public Medicamento execute(UUID uuid, Medicamento model) {

        var currentMedicamento = medicamentoDao.getById(uuid);

        if (currentMedicamento.getEstado() != null && currentMedicamento.getEstado() == 0) {

            throw new IllegalStateException("El medicamento ya se encuentra desactivado");

        }

        return medicamentoRepository.update(uuid, model);

    }

}
