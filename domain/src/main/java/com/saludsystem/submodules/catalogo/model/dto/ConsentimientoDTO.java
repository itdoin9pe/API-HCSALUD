package com.saludsystem.submodules.catalogo.model.dto;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearConsentimientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConsentimientoDTO extends CrearConsentimientoDTO {
    private UUID consentimientoId;

    public ConsentimientoDTO(UUID id, String texto, String nombre, String observacion, Integer estado) {
        this.setConsentimientoId(id);
        this.setTexto(texto);
        this.setNombre(nombre);
        this.setObservacion(observacion);
        this.setEstado(estado);
    }
}