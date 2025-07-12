package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarMedicamentoDTO;
import com.saludsystem.application.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.domain.catalogo.port.in.service.MedicamentoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoEditHandler {
    private final MedicamentoService medicamentoService;

    public MedicamentoEditHandler(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    public void execute(UUID uuid, ActualizarMedicamentoDTO dto){
        medicamentoService.update(uuid, MedicamentoMapper.fromUpdateDto(uuid, dto));
    }
}