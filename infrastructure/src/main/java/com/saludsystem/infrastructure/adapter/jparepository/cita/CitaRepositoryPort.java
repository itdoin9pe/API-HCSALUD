package com.saludsystem.infrastructure.adapter.jparepository.cita;

import com.saludsystem.domain.catalogo.model.Categoria;
import com.saludsystem.domain.cita.model.Cita;

import java.util.List;
import java.util.UUID;

public interface CitaRepositoryPort {
    Cita save(Cita cita);
    Cita update(UUID uuid, Cita cita);
    void delete(UUID uuid);
    Cita findById(UUID uuid);
    List<Categoria> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}