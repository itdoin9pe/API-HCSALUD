package com.saludsystem.submodules.catalogo.dtos.get;

import com.saludsystem.submodules.catalogo.dtos.post.CrearAlergiaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlergiaDTO extends CrearAlergiaDTO {
    private UUID alergiaId;

    public AlergiaDTO(UUID id, String nombre, Integer estado) {
        this.setAlergiaId(id); // el campo viene de CrearAlergiaDTO
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}