package com.saludsystem.application.catalogo.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearMedicamentoDTO {
    private String nombre;
    private String formaFarmaceutica;
    private String concentracion;
    private String contenido;
    @Schema(example = "0")
    private Integer estado;
}