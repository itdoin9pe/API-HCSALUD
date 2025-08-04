package com.saludsystem.submodules.operaciones.command.edit;

import com.saludsystem.submodules.operaciones.mapper.ProductoMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.ProductoEditCommand;
import com.saludsystem.submodules.operaciones.service.producto.ProductoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductoEditHandler {

    private final ProductoEditService productoEditService;
    private final ProductoMapper productoMapper;

    public ProductoEditHandler(ProductoEditService productoEditService, ProductoMapper productoMapper) {
        this.productoEditService = productoEditService;
        this.productoMapper = productoMapper;
    }

    public void execute(UUID uuid, ProductoEditCommand editCommand) {

        var prodUpdated = productoMapper.fromUpdateDto(uuid, editCommand);

        productoEditService.execute(uuid, prodUpdated);

    }

}
