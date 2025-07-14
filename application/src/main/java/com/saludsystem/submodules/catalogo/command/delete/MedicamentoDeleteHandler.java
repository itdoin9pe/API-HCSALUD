package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.in.service.MedicamentoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoDeleteHandler {
    private final MedicamentoService medicamentoService;

    public MedicamentoDeleteHandler(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    public void execute(UUID uuid){
        medicamentoService.delete(uuid);
    }
}