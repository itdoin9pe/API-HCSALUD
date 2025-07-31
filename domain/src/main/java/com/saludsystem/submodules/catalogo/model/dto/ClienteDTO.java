package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteDTO extends com.saludsystem.submodules.catalogo.model.dto.command.ClienteCreateCommand {
    private UUID clienteId;

    public ClienteDTO(
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