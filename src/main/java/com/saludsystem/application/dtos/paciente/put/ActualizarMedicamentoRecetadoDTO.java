package com.saludsystem.application.dtos.paciente.put;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarMedicamentoRecetadoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID medicamentoRecetadoId;

    private UUID medicamentoId;

    private String dosis;

    private String frecuencia;

    @Schema(example = "0")
    private Integer duracionDias;

    private String indicaciones;

}