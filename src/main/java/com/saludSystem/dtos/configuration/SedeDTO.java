package com.saludSystem.dtos.configuration;

import lombok.Data;

@Data
public class SedeDTO {
    private Integer id;
    private String codigo;
    private String nombre;
    private String direccion;
    private String ubigeo;
    private Integer estado;
}
