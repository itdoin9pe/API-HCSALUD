package com.saludsystem.submodules.mantenimiento.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TipoTarjeta {
    private UUID tipoTarjetaId;
    private String descripcion;
    private Integer estado;

    public TipoTarjeta(UUID tipoTarjetaId, String descripcion, Integer estado) {
        this.tipoTarjetaId = tipoTarjetaId;
        this.descripcion = descripcion;
        this.estado = estado;
    }
}
