package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EspecialidadDTO extends com.saludsystem.submodules.catalogo.model.dto.command.EspecialidadCreateCommand {
    private UUID especialidadId;

    public EspecialidadDTO(UUID id, String descripcion, String nombre, Integer estado) {
        this.setEspecialidadId(id);
        this.setDescripcion(descripcion);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}