package com.saludsystem.submodules.catalogo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApoderadoCreateCommand extends com.saludsystem.submodules.catalogo.model.dto.command.ApoderadoCreateCommand {
    private UUID apoderadoId;

    public ApoderadoCreateCommand(UUID id, String nombre, String nroDocumento, String direccion,
                                  String telefono, Integer estado) {
        this.setApoderadoId(id);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setNroDocumento(nroDocumento);
        this.setTelefono(telefono);
        this.setEstado(estado);
    }
}