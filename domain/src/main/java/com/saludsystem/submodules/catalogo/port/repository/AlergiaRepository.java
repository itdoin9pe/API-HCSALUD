package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Alergia;

import java.util.List;
import java.util.UUID;

public interface AlergiaRepository {
    Alergia save(Alergia alergia);
    Alergia update(UUID id, Alergia alergia);
    void delete(UUID id);
    Alergia findById(UUID id);
    List<Alergia> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}