package com.saludSystem.Operaciones.Unidad.aplicacion.dtos;

import lombok.Data;

@Data
public class CrearUnidadDTO {

    private String nombre;

    private String siglas;

    private String descripcion;

    private Integer estado;

}
