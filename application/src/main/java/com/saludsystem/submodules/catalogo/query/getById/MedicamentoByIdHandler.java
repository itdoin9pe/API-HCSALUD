package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoByIdHandler {

    private final MedicamentoByIdService medicamentoByIdService;

    public MedicamentoByIdHandler(MedicamentoByIdService medicamentoByIdService) {
        this.medicamentoByIdService = medicamentoByIdService;
    }

    public MedicamentoDTO execute(UUID uuid) {
        return medicamentoByIdService.execute(uuid);
    }
}