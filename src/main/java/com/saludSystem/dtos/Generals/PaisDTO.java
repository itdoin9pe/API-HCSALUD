package com.saludSystem.dtos.Generals;

import lombok.Data;

@Data
public class PaisDTO {
    private Integer id;
    private String iso;
    private String nombre;
    private String gentilicio;
    private Integer orden;
}
