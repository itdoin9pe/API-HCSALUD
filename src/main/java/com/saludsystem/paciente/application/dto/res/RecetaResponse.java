package com.saludsystem.paciente.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class RecetaResponse {

    private UUID pacienteRecetaId;

    private UUID pacienteId;

    private UUID doctorId;

    private LocalDate fecha;

    private String observaciones;

    @Schema(example = "0")
    private Integer estado;

}