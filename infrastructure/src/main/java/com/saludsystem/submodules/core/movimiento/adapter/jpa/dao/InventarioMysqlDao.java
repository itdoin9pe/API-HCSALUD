package com.saludsystem.submodules.core.movimiento.adapter.jpa.dao;

import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.movimiento.port.dao.InventarioDao;
import com.saludsystem.submodules.response.ListResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InventarioMysqlDao implements InventarioDao {
    @Override
    public Inventario getById(UUID uuid) {
        return null;
    }

    @Override
    public ListResponse<Inventario> getAll(UUID hospitalId, int page, int rows) {
        return null;
    }

    @Override
    public List<Inventario> getList() {
        return List.of();
    }
}
