package com.saludsystem.domain.movimiento.port.in.service;

import com.saludsystem.domain.movimiento.model.Compra;

import java.util.List;
import java.util.UUID;

public interface CompraService {

    Compra save(Compra compra);
    Compra update(UUID uuid, Compra compra);
    void delete(UUID uuid);
    Compra getById(UUID uuid);
    List<Compra> getAll(UUID hospitalId, int page, int rows);

}