package com.saludsystem.submodules.catalogo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EspecialidadCreateCommand extends com.saludsystem.submodules.catalogo.model.dto.command.EspecialidadCreateCommand {
    private UUID especialidadId;

    public EspecialidadCreateCommand(UUID id, String descripcion, String nombre, Integer estado) {
        this.setEspecialidadId(id);
        this.setDescripcion(descripcion);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}