package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Medicamento;

import java.util.List;
import java.util.UUID;

public interface MedicamentoDao {
    Medicamento save(Medicamento medicamento);
    Medicamento update(UUID uuid, Medicamento medicamento);
    void delete(UUID uuid);
    Medicamento getById(UUID uuid);
    List<Medicamento> getAll(UUID hospitalId, int page, int rows);
}