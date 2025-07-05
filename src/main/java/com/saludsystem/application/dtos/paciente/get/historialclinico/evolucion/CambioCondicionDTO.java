package com.saludsystem.application.dtos.paciente.get.historialclinico.evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CambioCondicionDTO {

    @Schema(example = "Integer")
    private Long evolucionCambioCondicionId;

    private LocalDateTime fecha;

    private String descripcion;

    private UUID pacienteEvolucionId;

}