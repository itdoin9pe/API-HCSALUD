package com.saludsystem.submodules.catalogo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AlergiaDTO {

    private UUID alergiaId;

    private String nombre;

    @Schema(description = "Estado (0=Inactivo, 1=Activo)", example = "1")
    private Integer estado;

    public AlergiaDTO(UUID id, String nombre, Integer estado) {
        this.setAlergiaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}