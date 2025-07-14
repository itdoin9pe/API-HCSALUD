package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dtos.put.ActualizarMedicamentoDTO;
import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.port.in.service.MedicamentoService;
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