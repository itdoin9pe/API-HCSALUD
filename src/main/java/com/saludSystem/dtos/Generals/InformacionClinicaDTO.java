package com.saludSystem.dtos.Generals;

import lombok.Data;

import java.util.UUID;

@Data
public class InformacionClinicaDTO {

    private UUID id;
    private String nombre;
    private Integer estado;

}
