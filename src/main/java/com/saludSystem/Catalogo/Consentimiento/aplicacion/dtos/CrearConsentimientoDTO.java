package com.saludSystem.Catalogo.Consentimiento.aplicacion.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CrearConsentimientoDTO {

    private String nombre;

    private String observacion;

    private Integer estado;

    private String texto;

}