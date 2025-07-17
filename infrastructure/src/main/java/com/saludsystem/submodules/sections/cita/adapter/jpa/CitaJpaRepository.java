package com.saludsystem.submodules.sections.cita.adapter.jpa;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.cita.model.Cita;

import java.util.List;
import java.util.UUID;

public interface CitaJpaRepository {
    Cita save(Cita cita);
    Cita update(UUID uuid, Cita cita);
    void delete(UUID uuid);
    Cita findById(UUID uuid);
    List<Categoria> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}