package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.MedicamentoService;
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