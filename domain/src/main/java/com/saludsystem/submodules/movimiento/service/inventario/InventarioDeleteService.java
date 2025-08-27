package com.saludsystem.submodules.movimiento.service.inventario;

import com.saludsystem.submodules.movimiento.port.dao.InventarioDao;
import com.saludsystem.submodules.movimiento.port.repository.InventarioRepository;

import java.util.UUID;

public class InventarioDeleteService {

    private final InventarioRepository inventarioRepository;
    private final InventarioDao inventarioDao;

    public InventarioDeleteService(InventarioRepository inventarioRepository, InventarioDao inventarioDao) {
        this.inventarioRepository = inventarioRepository;
        this.inventarioDao = inventarioDao;
    }

    public void execute(UUID uuid) {
        var inventario = inventarioDao.getById(uuid);
        if (inventario.getEstado() != null && inventario.getEstado() == 0) {
            throw new IllegalStateException("No se puede eliminar el inventario desactivado");
        }
        inventarioRepository.delete(uuid);
    }

}