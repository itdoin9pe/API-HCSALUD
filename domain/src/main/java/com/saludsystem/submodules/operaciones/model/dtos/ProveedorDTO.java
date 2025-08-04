package com.saludsystem.submodules.operaciones.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProveedorDTO extends com.saludsystem.submodules.operaciones.model.dtos.command.ProveedorCreateCommand {

    private UUID proveedorId;

    public ProveedorDTO(UUID proveedorId, String ruc, String nombre, String direccion, String telefono, String correo,
                        String contacto) {
        this.setProveedorId(proveedorId);
        this.setRuc(ruc);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setCorreo(correo);
        this.setContacto(contacto);
    }
}