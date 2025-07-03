package com.saludsystem.application.dtos.principal.get;

import lombok.Data;

@Data
public class ServicioDTO {

    public Long id;
    public String nombre;
    public String descripcion;
    public Integer estado;

}