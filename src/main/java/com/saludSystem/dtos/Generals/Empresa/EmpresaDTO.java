package com.saludSystem.dtos.Generals.Empresa;

import lombok.Data;

import java.util.UUID;

@Data
public class EmpresaDTO {
    private UUID id;
    private String descripcion;
    private Integer estado;
}
