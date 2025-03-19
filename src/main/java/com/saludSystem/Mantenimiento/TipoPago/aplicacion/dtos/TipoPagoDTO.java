package com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class TipoPagoDTO {

    private UUID tipoPagoId;

    private String metodoPago;

    private String descripcion;

    private Integer estado;

}
