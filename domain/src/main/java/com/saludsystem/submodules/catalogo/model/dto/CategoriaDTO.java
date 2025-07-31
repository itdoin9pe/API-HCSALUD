package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CategoriaDTO extends com.saludsystem.submodules.catalogo.model.dto.command.CategoriaCreateCommand {
    private UUID categoriaId;

    public CategoriaDTO(UUID id, String nombre, Integer estado) {
        this.setCategoriaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}