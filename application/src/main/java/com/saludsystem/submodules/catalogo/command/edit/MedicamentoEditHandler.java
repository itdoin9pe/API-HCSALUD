package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarMedicamentoDTO;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoEditHandler {

    private final MedicamentoEditService medicamentoEditService;

    public MedicamentoEditHandler(MedicamentoEditService medicamentoEditService) {
        this.medicamentoEditService = medicamentoEditService;
    }

    public void execute(UUID uuid, ActualizarMedicamentoDTO dto) {
        medicamentoEditService.execute(uuid, dto);
    }

}