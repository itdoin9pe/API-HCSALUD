package com.saludsystem.domain.catalogo.port.out.repository;

import com.saludsystem.domain.catalogo.model.Medida;

import java.util.List;
import java.util.UUID;

public interface MedidaRepositoryPort {
    Medida save(Medida medida);
    Medida update(UUID uuid, Medida medida);
    void delete(UUID uuid);
    Medida findById(UUID uuid);
    List<Medida> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}