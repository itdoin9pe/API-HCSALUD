package com.saludsystem.submodules.catalogo.model.dto;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearAlergiaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlergiaDTO extends CrearAlergiaDTO {
    private UUID alergiaId;

    public AlergiaDTO(UUID id, String nombre, Integer estado) {
        this.setAlergiaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}