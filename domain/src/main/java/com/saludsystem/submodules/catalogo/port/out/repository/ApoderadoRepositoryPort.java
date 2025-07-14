package com.saludsystem.submodules.catalogo.port.out.repository;

import com.saludsystem.submodules.catalogo.model.Apoderado;

import java.util.List;
import java.util.UUID;

public interface ApoderadoRepositoryPort {
    Apoderado save(Apoderado apoderado);
    Apoderado update(UUID uuid, Apoderado apoderado);
    void delete(UUID uuid);
    Apoderado findById(UUID uuid);
    List<Apoderado> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}