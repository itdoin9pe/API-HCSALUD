package com.saludsystem.submodules.operaciones.dtos.query;

import com.saludsystem.submodules.operaciones.dtos.command.CrearCategotiaMatDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoriaMatDTO extends CrearCategotiaMatDTO {

    private UUID categoriaMaterialId;

    public CategoriaMatDTO(UUID categoriaMaterialId, String nombre, String descripcion, Integer estado) {
        this.setCategoriaMaterialId(categoriaMaterialId);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}