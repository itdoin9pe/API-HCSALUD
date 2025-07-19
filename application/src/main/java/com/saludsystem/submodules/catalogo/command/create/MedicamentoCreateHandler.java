package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearMedicamentoDTO;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoCreateService;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoCreateHandler {

    private final MedicamentoCreateService medicamentoCreateService;

    public MedicamentoCreateHandler(MedicamentoCreateService medicamentoCreateService) {
        this.medicamentoCreateService = medicamentoCreateService;
    }

    public void execute(CrearMedicamentoDTO dto){
        medicamentoCreateService.execute(dto);
    }
}