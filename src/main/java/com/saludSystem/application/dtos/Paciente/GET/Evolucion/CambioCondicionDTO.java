package com.saludSystem.application.dtos.Paciente.GET.Evolucion;

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
    private UUID evolucionId;

}