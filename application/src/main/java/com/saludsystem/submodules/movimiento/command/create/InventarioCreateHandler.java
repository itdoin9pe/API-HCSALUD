package com.saludsystem.submodules.movimiento.command.create;

import com.saludsystem.submodules.movimiento.mapper.InventarioMapper;
import com.saludsystem.submodules.movimiento.service.inventario.InventarioCreateService;
import org.springframework.stereotype.Component;

@Component
public class InventarioCreateHandler {

    private final InventarioCreateService inventarioCreateService;
    private final InventarioMapper inventarioMapper;

    public InventarioCreateHandler(InventarioCreateService inventarioCreateService, InventarioMapper inventarioMapper) {
        this.inventarioCreateService = inventarioCreateService;
        this.inventarioMapper = inventarioMapper;
    }


}
