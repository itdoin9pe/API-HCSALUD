package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.MedicamentoDTO;
import com.saludsystem.application.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.domain.catalogo.model.Medicamento;
import com.saludsystem.domain.catalogo.port.in.service.MedicamentoService;
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