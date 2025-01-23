package com.saludSystem.dtos.Generals.InformacionClinica;

import lombok.Data;

import java.util.UUID;

@Data
public class InformacionClinicaDTO {

    private UUID id;
    private String nombre;
    private Integer estado;

}
