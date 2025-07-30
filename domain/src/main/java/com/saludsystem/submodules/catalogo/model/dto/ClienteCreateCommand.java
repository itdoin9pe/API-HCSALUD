package com.saludsystem.submodules.catalogo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClienteCreateCommand extends com.saludsystem.submodules.catalogo.model.dto.command.ClienteCreateCommand {
    private UUID clienteId;

    public ClienteCreateCommand(
            UUID id, String tipoDocumento, String nombre,
            String direccion, String contacto, String email, String tipoDocumento1, Integer estado) {
        this.setClienteId(id);
        this.setTipoDocumento(tipoDocumento);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setContacto(contacto);
        this.setEmail(email);
        this.setTipoDocumento(tipoDocumento);
        this.setEstado(estado);
    }
}