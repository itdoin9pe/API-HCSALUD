package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MedidaDTO extends com.saludsystem.submodules.catalogo.model.dto.command.MedidaCreateCommand {
    private UUID medidaId;

    public MedidaDTO(UUID id, String nombre, Integer estado) {
        this.setMedidaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}