package com.saludSystem.application.dtos.Paciente.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarMedicamentoRecetadoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID medicamentoRecetadoDTO;

    private UUID medicamentoId;

    private String dosis;

    private String frecuencia;

    @Schema(example = "0")
    private Integer duracionDias;

    private String indicaciones;

}