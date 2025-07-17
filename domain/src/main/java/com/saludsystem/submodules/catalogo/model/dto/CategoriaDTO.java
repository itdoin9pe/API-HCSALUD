package com.saludsystem.submodules.catalogo.model.dto;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearCategoriaDTO;
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