package com.saludsystem.submodules.catalogo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConsentimientoCreateCommand extends com.saludsystem.submodules.catalogo.model.dto.command.ConsentimientoCreateCommand {
    private UUID consentimientoId;

    public ConsentimientoCreateCommand(UUID id, String texto, String nombre, String observacion, Integer estado) {
        this.setConsentimientoId(id);
        this.setTexto(texto);
        this.setNombre(nombre);
        this.setObservacion(observacion);
        this.setEstado(estado);
    }
}