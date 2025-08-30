package com.saludsystem.submodules.mantenimiento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class TipoPago {
    private UUID tipoPagoId;
    private String metodoPago;
    private String descripcion;
    private Integer estado;

    public TipoPago(UUID tipoPagoId, String metodoPago, String descripcion, Integer estado) {
        this.tipoPagoId = tipoPagoId;
        this.metodoPago = metodoPago;
        this.descripcion = descripcion;
        this.estado = estado;
    }
}