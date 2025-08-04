package com.saludsystem.submodules.operaciones.model.dtos;

import com.saludsystem.submodules.operaciones.model.dtos.command.CategotiaMatCreateCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoriaMatDTO extends CategotiaMatCreateCommand {

    private UUID categoriaMaterialId;

    public CategoriaMatDTO(UUID categoriaMaterialId, String nombre, String descripcion, Integer estado) {
        this.setCategoriaMaterialId(categoriaMaterialId);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}