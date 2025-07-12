package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.MedicamentoDTO;
import com.saludsystem.application.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.domain.catalogo.model.Medicamento;
import com.saludsystem.domain.catalogo.port.in.service.MedicamentoService;
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