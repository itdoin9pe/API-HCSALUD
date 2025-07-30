package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.MedicamentoCreateCommand;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoCreateService;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoCreateHandler {

    private final MedicamentoCreateService medicamentoCreateService;

    public MedicamentoCreateHandler(MedicamentoCreateService medicamentoCreateService) {
        this.medicamentoCreateService = medicamentoCreateService;
    }

    public void execute(MedicamentoCreateCommand dto){
        medicamentoCreateService.execute(dto);
    }
}