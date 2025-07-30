package com.saludsystem.submodules.catalogo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlergiaCreateCommand extends com.saludsystem.submodules.catalogo.model.dto.command.AlergiaCreateCommand {
    private UUID alergiaId;

    public AlergiaCreateCommand(UUID id, String nombre, Integer estado) {
        this.setAlergiaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}