package com.saludsystem.submodules.catalogo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoriaCreateCommand extends com.saludsystem.submodules.catalogo.model.dto.command.CategoriaCreateCommand {
    private UUID categoriaId;

    public CategoriaCreateCommand(UUID id, String nombre, Integer estado) {
        this.setCategoriaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}