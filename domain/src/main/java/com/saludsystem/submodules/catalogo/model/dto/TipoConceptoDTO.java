package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoConceptoDTO extends com.saludsystem.submodules.catalogo.model.dto.command.TipoConceptoCreateCommand {
    private UUID tipoConceptoId;

    public TipoConceptoDTO(UUID id, String nombre, Integer estado) {
        this.setTipoConceptoId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}