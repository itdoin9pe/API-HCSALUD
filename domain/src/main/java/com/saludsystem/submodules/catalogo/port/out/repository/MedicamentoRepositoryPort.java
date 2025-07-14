package com.saludsystem.submodules.catalogo.port.out.repository;

import com.saludsystem.submodules.catalogo.model.Medicamento;

import java.util.List;
import java.util.UUID;

public interface MedicamentoRepositoryPort {
    Medicamento save(Medicamento medicamento);
    Medicamento update(UUID uuid, Medicamento medicamento);
    void delete(UUID uuid);
    Medicamento findById(UUID uuid);
    List<Medicamento> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}