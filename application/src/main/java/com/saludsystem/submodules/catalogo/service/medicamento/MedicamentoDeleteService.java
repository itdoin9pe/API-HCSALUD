package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;

import java.util.UUID;

public class MedicamentoDeleteService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoDeleteService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public void execute(UUID uuid) {
        medicamentoRepository.delete(uuid);
    }
}
