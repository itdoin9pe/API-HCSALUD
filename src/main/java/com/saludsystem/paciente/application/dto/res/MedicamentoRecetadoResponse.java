package com.saludsystem.paciente.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.util.UUID;

@Data
public class MedicamentoRecetadoResponse {

    private UUID medicamentoRecetadoId;

    private UUID medicamentoId;

    private String dosis;

    private String frecuencia;

    @Schema(example = "0")
    private Integer duracionDias;

    private String indicaciones;

}