package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoDeleteHandler {

    private final MedicamentoDeleteService medicamentoDeleteService;

    public MedicamentoDeleteHandler(MedicamentoDeleteService medicamentoDeleteService) {
        this.medicamentoDeleteService = medicamentoDeleteService;
    }

    public void execute(UUID uuid) {
        medicamentoDeleteService.execute(uuid);
    }
}