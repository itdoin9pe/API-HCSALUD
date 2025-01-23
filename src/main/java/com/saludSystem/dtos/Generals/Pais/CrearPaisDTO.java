package com.saludSystem.dtos.Generals.Pais;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearPaisDTO {
    private String iso;
    private String nombre;
    private String gentilicio;
    private Integer orden;
}
