package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Consentimiento;

import java.util.List;
import java.util.UUID;

public interface ConsentimientoRepository {
    Consentimiento save(Consentimiento consentimiento);
    Consentimiento update(UUID uuid, Consentimiento consentimiento);
    void delete(UUID uuid);
    Consentimiento findById(UUID uuid);
    List<Consentimiento> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}