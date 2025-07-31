package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AlergiaDTO extends com.saludsystem.submodules.catalogo.model.dto.command.AlergiaCreateCommand {
    private UUID alergiaId;

    public AlergiaDTO(UUID id, String nombre, Integer estado) {
        this.setAlergiaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}