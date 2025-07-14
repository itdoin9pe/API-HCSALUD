package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dtos.get.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.in.service.MedicamentoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MedicamentoAllHandler {
    private final MedicamentoService medicamentoService;

    public MedicamentoAllHandler(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    public List<MedicamentoDTO> execute(UUID hospitalId, int page, int rows) {
        List<Medicamento> models = medicamentoService.getAll(hospitalId, page, rows);
        return models.stream().map(MedicamentoMapper::toDto).toList();
    }
}