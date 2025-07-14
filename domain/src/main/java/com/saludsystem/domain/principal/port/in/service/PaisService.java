package com.saludsystem.domain.principal.port.in.service;

import com.saludsystem.domain.principal.model.Pais;

import java.util.List;
import java.util.UUID;

public interface PaisService {

    Pais save(Pais pais);
    Pais update(UUID uuid, Pais pais);
    void delete(UUID uuid);
    Pais getById(UUID uuid);
    List<Pais> getAll(UUID hospitalId, int page, int rows);

}