package com.saludSystem.application.dtos.Paciente.GET.Evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AltaMedicaDTO {

    @Schema(example = "Integer")
    private Long evolucionAltaMedicaId;

    private LocalDateTime fecha;

    private String resumenFinal;

    private UUID pacienteEvolucionId;

}