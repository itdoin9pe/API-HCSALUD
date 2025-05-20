package com.saludSystem.application.dtos.Paciente.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class MedicamentoRecetadoDTO {

    private UUID medicamentoRecetadoDTO;

    private UUID medicamentoId;

    private String dosis;

    private String frecuencia;

    @Schema(example = "0")
    private Integer duracionDias;

    private String indicaciones;

}