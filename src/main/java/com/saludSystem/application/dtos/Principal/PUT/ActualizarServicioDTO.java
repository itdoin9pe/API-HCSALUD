package com.saludSystem.application.dtos.Principal.PUT;

import lombok.Data;

@Data
public class ActualizarServicioDTO {
    public Long id;
    public String nombre;
    public String descripcion;
    public Integer estado;
}
