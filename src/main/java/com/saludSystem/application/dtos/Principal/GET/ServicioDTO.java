package com.saludSystem.application.dtos.Principal.GET;

import lombok.Data;

@Data
public class ServicioDTO {

    public Long id;
    public String nombre;
    public String descripcion;
    public Integer estado;

}