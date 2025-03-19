package com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos;

import lombok.Data;

@Data
public class CrearTipoPagoDTO {

    private String metodoPago;

    private String descripcion;

    private Integer estado;

}
