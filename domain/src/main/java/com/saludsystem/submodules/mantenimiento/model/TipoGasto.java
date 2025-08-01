package com.saludsystem.submodules.mantenimiento.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TipoGasto {

    private UUID conceptoGastoId;
    private String nombre;
    private Integer estado;

    public TipoGasto(UUID conceptoGastoId, String nombre, Integer estado) {
        this.conceptoGastoId = conceptoGastoId;
        this.nombre = nombre;
        this.estado = estado;
    }

}
