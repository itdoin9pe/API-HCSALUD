package com.saludsystem.submodules.operaciones.command.edit;

import com.saludsystem.submodules.operaciones.mapper.ProveedorMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.ProveedorEditCommand;
import com.saludsystem.submodules.operaciones.service.proveedor.ProveedorEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProveedorEditHandler {

    private final ProveedorEditService proveedorEditService;
    private final ProveedorMapper proveedorMapper;

    public ProveedorEditHandler(ProveedorEditService proveedorEditService, ProveedorMapper proveedorMapper) {
        this.proveedorEditService = proveedorEditService;
        this.proveedorMapper = proveedorMapper;
    }

    public void execute(UUID uuid, ProveedorEditCommand editCommand) {

        var proveedor = proveedorMapper.fromUpdateDto(uuid, editCommand);

        proveedorEditService.execute(uuid, proveedor);

    }

}
