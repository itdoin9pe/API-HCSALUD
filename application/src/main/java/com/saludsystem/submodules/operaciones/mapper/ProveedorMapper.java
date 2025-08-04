package com.saludsystem.submodules.operaciones.mapper;

import com.saludsystem.submodules.operaciones.model.Proveedor;
import com.saludsystem.submodules.operaciones.model.dtos.ProveedorDTO;
import com.saludsystem.submodules.operaciones.model.dtos.command.ProveedorCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.ProveedorEditCommand;

import java.util.UUID;

public class ProveedorMapper {

    public Proveedor fromCreateDto(ProveedorCreateCommand createCommand) {

        return new Proveedor(null, createCommand.getRuc(), createCommand.getNombre(),
                createCommand.getDireccion(), createCommand.getTelefono(),
                createCommand.getCorreo(), createCommand.getContacto());

    }

    public Proveedor fromUpdateDto(UUID uuid, ProveedorEditCommand editCommand) {

        return new Proveedor(uuid, editCommand.getRuc(), editCommand.getNombre(),
                editCommand.getDireccion(), editCommand.getTelefono(),
                editCommand.getCorreo(), editCommand.getContacto());

    }

    public ProveedorDTO toDto(Proveedor proveedor) {
        return new ProveedorDTO(
                proveedor.getProveedorId(), proveedor.getRuc(), proveedor.getNombre(),
                proveedor.getDireccion(), proveedor.getTelefono(),
                proveedor.getCorreo(), proveedor.getContacto());
    }

}
