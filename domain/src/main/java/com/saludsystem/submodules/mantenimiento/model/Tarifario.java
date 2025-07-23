package com.saludsystem.submodules.mantenimiento.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Tarifario {
    private UUID id;
    private UUID tipoConceptoId;
    private UUID medidaId;
    private UUID categoriaId;
    private UUID unidadId;
    private String grupo;
    private String descripcion;
    private Double precio;
    private Integer estado;

    public Tarifario(UUID id, UUID tipoConceptoId, UUID categoriaId, UUID medidaId,
                     UUID unidadId, String grupo, String descripcion, Double precio,
                     Integer estado) {
        this.id = id;
        this.tipoConceptoId = tipoConceptoId;
        this.categoriaId = categoriaId;
        this.medidaId = medidaId;
        this.unidadId = unidadId;
        this.grupo = grupo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }
}
