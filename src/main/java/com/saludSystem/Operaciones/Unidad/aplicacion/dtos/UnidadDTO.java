package com.saludSystem.Operaciones.Unidad.aplicacion.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class UnidadDTO {

    private UUID unidadId;

    private String nombre;

    private String siglas;

    private String descripcion;

    private Integer estado;

}
