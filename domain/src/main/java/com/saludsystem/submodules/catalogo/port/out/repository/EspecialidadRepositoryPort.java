package com.saludsystem.submodules.catalogo.port.out.repository;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EspecialidadRepositoryPort {
    Especialidad save(Especialidad especialidad);
    Especialidad update(UUID uuid, Especialidad especialidad);
    void delete(UUID uuid);
    Especialidad findById(UUID uuid);
    ListResponse<Especialidad> findAll(UUID hospitalId, int page, int rows);
    List<Especialidad> findList();
    long countByHospitalId(UUID hospitalId);
}