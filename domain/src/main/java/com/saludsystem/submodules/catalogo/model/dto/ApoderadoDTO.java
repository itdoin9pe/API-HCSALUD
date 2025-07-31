package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApoderadoDTO extends com.saludsystem.submodules.catalogo.model.dto.command.ApoderadoCreateCommand {
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