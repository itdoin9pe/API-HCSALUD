package com.saludsystem.paciente.application.dto.evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ActualizarCambioCondicionDTO {

    private UUID hospitalId;

    private UUID userId;

    @Schema(example = "Integer")
    private Long evolucionCambioCondicionId;

    private LocalDateTime fecha;

    private String descripcion;

    private UUID pacienteEvolucionId;

}