package com.saludsystem.submodules.catalogo.dtos.get;

import com.saludsystem.submodules.catalogo.dtos.post.CrearCategoriaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoriaDTO extends CrearCategoriaDTO {
    private UUID categoriaId;

    public CategoriaDTO(UUID id, String nombre, Integer estado) {
        this.setCategoriaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}