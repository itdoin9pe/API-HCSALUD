package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.dto.MedicamentoCreateCommand;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicamentoListHandler {

    private final MedicamentoListService medicamentoListService;

    public MedicamentoListHandler(MedicamentoListService medicamentoListService) {
        this.medicamentoListService = medicamentoListService;
    }

    public List<MedicamentoCreateCommand> execute() {
        return medicamentoListService.execute();
    }
}
