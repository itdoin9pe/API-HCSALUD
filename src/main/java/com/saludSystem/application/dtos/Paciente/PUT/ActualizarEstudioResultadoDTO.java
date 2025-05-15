package com.saludSystem.application.dtos.Paciente.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ActualizarEstudioResultadoDTO {

    private UUID hospitalId;

    private UUID userId;

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

    private String reporteTexto;

    private String urlImg;

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

    private LocalDateTime createdAt;

}