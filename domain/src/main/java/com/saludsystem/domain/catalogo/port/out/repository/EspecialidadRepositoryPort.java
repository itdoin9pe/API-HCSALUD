package com.saludsystem.domain.catalogo.port.out.repository;

import com.saludsystem.domain.catalogo.model.Especialidad;

import java.util.List;
import java.util.UUID;

public interface EspecialidadRepositoryPort {
    Especialidad save(Especialidad especialidad);
    Especialidad update(UUID uuid, Especialidad especialidad);
    void delete(UUID uuid);
    Especialidad findById(UUID uuid);
    List<Especialidad> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}