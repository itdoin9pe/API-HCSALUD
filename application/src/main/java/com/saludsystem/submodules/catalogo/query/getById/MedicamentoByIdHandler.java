package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.in.service.MedicamentoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoByIdHandler {
    private final MedicamentoService medicamentoService;

    public MedicamentoByIdHandler(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    public MedicamentoDTO execute(UUID uuid) {
        Medicamento model = medicamentoService.getById(uuid);
        return MedicamentoMapper.toDto(model);
    }
}