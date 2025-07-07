package com.saludsystem.application.dtos.catalogo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class MedicamentoDTO {
    private UUID medicamentoId;
    private String nombre;
    private String formaFarmaceutica;
    private String concentracion;
    private String contenido;
    @Schema(description = "Estado (1=Activo, 0=Inactivo)", example = "1")
    private Integer estado;
}