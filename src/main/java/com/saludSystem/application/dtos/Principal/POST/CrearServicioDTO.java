package com.saludSystem.application.dtos.Principal.POST;

import lombok.Data;

@Data
public class CrearServicioDTO {
    public String nombre;
    public String descripcion;
    public Integer estado;
}
