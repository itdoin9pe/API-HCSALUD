package com.saludSystem.dtos.configuration.Sede;

import lombok.Data;

@Data
public class CrearSedeDTO {
    private String codigo;
    private String nombre;
    private String direccion;
    private String ubigeo;
    private Integer estado;
}
