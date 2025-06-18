package com.saludSystem.application.dtos.Catalogo.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarMedicamentoDTO {
    private UUID hospitalId;
    private UUID userId;
    private UUID medicamentoId;
    private String nombre;
    private String formaFarmaceutica;
    private String concentracion;
    private String contenido;
    @Schema(example = "0")
    private Integer estado;
}