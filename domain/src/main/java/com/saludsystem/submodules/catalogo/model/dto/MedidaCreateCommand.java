package com.saludsystem.submodules.catalogo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedidaCreateCommand extends com.saludsystem.submodules.catalogo.model.dto.command.MedidaCreateCommand {
    private UUID medidaId;

    public MedidaCreateCommand(UUID id, String nombre, Integer estado) {
        this.setMedidaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}