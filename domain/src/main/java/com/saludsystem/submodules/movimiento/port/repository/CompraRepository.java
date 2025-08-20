package com.saludsystem.submodules.movimiento.port.repository;

import com.saludsystem.submodules.movimiento.model.Compra;

import java.util.UUID;

public interface CompraRepository {

    Compra save(Compra compra);

    Compra update(UUID uuid, Compra compra);

    void delete(UUID uuid);

}