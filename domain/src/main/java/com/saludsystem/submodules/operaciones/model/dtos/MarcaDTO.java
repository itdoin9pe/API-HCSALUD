package com.saludsystem.submodules.operaciones.model.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MarcaDTO extends com.saludsystem.submodules.operaciones.model.dtos.command.MarcaCreateCommand {

    private UUID marcaId;

    public MarcaDTO(UUID id, String nombre, Integer estado) {
        this.setMarcaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}