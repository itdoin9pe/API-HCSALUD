package com.saludsystem.submodules.operaciones.model.dtos.get;

import com.saludsystem.submodules.operaciones.model.dtos.post.CrearCategotiaMatDTO;
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