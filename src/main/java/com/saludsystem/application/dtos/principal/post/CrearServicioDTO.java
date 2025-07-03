package com.saludsystem.application.dtos.principal.post;

import lombok.Data;

@Data
public class CrearServicioDTO {
    public String nombre;
    public String descripcion;
    public Integer estado;
}
