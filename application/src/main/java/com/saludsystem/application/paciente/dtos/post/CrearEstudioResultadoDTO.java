package com.saludsystem.application.paciente.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CrearEstudioResultadoDTO {

    private String reporteTexto;

    private String urlImg;

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

    private LocalDateTime createdAt;

}