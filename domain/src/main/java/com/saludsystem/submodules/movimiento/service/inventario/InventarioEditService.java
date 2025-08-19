package com.saludsystem.submodules.movimiento.service.inventario;

import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.movimiento.model.constant.InventarioConstant;
import com.saludsystem.submodules.movimiento.port.dao.InventarioDao;
import com.saludsystem.submodules.movimiento.port.repository.InventarioRepository;

import java.util.UUID;

public class InventarioEditService {

    private final InventarioDao inventarioDao;
    private final InventarioRepository inventarioRepository;

    public InventarioEditService(InventarioDao inventarioDao, InventarioRepository inventarioRepository) {
        this.inventarioDao = inventarioDao;
        this.inventarioRepository = inventarioRepository;
    }

    public Inventario execute(UUID uuid, Inventario inventario) {

        var currentInventario = inventarioDao.getById(uuid);

        if (currentInventario == null) {

            throw new IllegalArgumentException(InventarioConstant.INVALID_ID);

        }

        if (inventario.getEstado() != null && inventario.getEstado() == 0) {

            throw new IllegalStateException("El inventario esta desactivado");

        }

        return inventarioRepository.update(uuid, inventario);

    }

}
