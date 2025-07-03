package com.saludsystem.application.dtos.principal.put;

import lombok.Data;

@Data
public class ActualizarServicioDTO {
    public Long id;
    public String nombre;
    public String descripcion;
    public Integer estado;
}
