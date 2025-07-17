package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Consentimiento;

import java.util.List;
import java.util.UUID;

public interface ConsentimientoDao {
    Consentimiento save(Consentimiento consentimiento);
    Consentimiento update(UUID uuid, Consentimiento consentimiento);
    void delete(UUID uuid);
    Consentimiento getById(UUID uuid);
    List<Consentimiento> getAll(UUID hospitalId, int page, int rows);
}