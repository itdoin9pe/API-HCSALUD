package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.domain.catalogo.model.Medicamento;

import java.util.List;
import java.util.UUID;

public interface MedicamentoService {
    Medicamento save(Medicamento medicamento);
    Medicamento update(UUID uuid, Medicamento medicamento);
    void delete(UUID uuid);
    Medicamento getById(UUID uuid);
    List<Medicamento> getAll(UUID hospitalId, int page, int rows);
}