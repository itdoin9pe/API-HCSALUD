package com.saludSystem.dtos.configuration;

import lombok.Data;

import java.util.UUID;

@Data
public class SedeDTO {
    private UUID id;
    private String codigo;
    private String nombre;
    private String direccion;
    private String ubigeo;
    private Integer estado;
}
