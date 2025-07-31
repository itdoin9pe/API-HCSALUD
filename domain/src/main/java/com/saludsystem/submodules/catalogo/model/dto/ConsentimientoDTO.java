package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ConsentimientoDTO extends com.saludsystem.submodules.catalogo.model.dto.command.ConsentimientoCreateCommand {
    private UUID consentimientoId;

    public ConsentimientoDTO(UUID id, String texto, String nombre, String observacion, Integer estado) {
        this.setConsentimientoId(id);
        this.setTexto(texto);
        this.setNombre(nombre);
        this.setObservacion(observacion);
        this.setEstado(estado);
    }
}