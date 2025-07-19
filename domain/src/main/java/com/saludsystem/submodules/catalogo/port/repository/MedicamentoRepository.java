package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Medicamento;

import java.util.UUID;

public interface MedicamentoRepository {
    Medicamento save(Medicamento medicamento);
    Medicamento update(UUID uuid, Medicamento medicamento);
    void delete(UUID uuid);
}