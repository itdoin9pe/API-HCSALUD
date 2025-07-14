package com.saludsystem.submodules.catalogo.port.in.service;

import com.saludsystem.submodules.catalogo.model.Consentimiento;

import java.util.List;
import java.util.UUID;

public interface ConsentimientoService {
    Consentimiento save(Consentimiento consentimiento);
    Consentimiento update(UUID uuid, Consentimiento consentimiento);
    void delete(UUID uuid);
    Consentimiento getById(UUID uuid);
    List<Consentimiento> getAll(UUID hospitalId, int page, int rows);
}