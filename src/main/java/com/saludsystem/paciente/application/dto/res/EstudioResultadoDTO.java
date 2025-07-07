package com.saludsystem.paciente.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EstudioResultadoDTO {

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

    private String reporteTexto;

    private String urlImg;

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

    private LocalDateTime createdAt;

}