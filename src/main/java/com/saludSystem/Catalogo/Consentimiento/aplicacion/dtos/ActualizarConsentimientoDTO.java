package com.saludSystem.Catalogo.Consentimiento.aplicacion.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarConsentimientoDTO {

    private UUID consentimientoId;

    private String nombre;

    private String observacion;

    private Integer estado;

    private String texto;

}