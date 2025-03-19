package com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarTipoPagoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID tipoPagoId;

    private String metodoPago;

    private String descripcion;

    private Integer estado;

}
