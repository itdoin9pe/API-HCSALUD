package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.domain.catalogo.model.Medida;

import java.util.List;
import java.util.UUID;

public interface MedidaService {
    Medida save(Medida medida);
    Medida update(UUID uuid, Medida medida);
    void delete(UUID uuid);
    Medida getById(UUID uuid);
    List<Medida> getAll(UUID hospitalId, int page, int rows);
}