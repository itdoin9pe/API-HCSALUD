package com.saludsystem.application.catalogo.dtos.get;

import com.saludsystem.application.catalogo.dtos.post.CrearClienteDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClienteDTO extends CrearClienteDTO {
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