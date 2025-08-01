package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Consentimiento;

import java.util.UUID;

public interface ConsentimientoRepository {
    Consentimiento save(Consentimiento consentimiento);
    Consentimiento update(UUID uuid, Consentimiento consentimiento);
    void delete(UUID uuid);
}