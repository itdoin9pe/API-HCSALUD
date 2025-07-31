package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoCitadoDTO extends com.saludsystem.submodules.catalogo.model.dto.command.TipoCitadoCreateCommand {
    private UUID tipoCitadoId;

    public TipoCitadoDTO(UUID id, String nombre, String color, Integer estado) {
        this.setTipoCitadoId(id);
        this.setNombre(nombre);
        this.setColor(color);
        this.setEstado(estado);
    }
}
