package com.saludsystem.application.catalogo.dtos.get;

import com.saludsystem.application.catalogo.dtos.post.CrearApoderadoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApoderadoDTO extends CrearApoderadoDTO {
    private UUID apoderadoId;

    public ApoderadoDTO(UUID id, String nombre, String nroDocumento, String direccion,
                        String telefono, Integer estado) {
        this.setApoderadoId(id);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setNroDocumento(nroDocumento);
        this.setTelefono(telefono);
        this.setEstado(estado);
    }
}