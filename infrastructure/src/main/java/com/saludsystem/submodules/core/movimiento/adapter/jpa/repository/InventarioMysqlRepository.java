package com.saludsystem.submodules.core.movimiento.adapter.jpa.repository;

import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.movimiento.port.repository.InventarioRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InventarioMysqlRepository implements InventarioRepository {
    @Override
    public Inventario save(Inventario inventario) {
        return null;
    }

    @Override
    public Inventario update(UUID uuid, Inventario inventario) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }
}
