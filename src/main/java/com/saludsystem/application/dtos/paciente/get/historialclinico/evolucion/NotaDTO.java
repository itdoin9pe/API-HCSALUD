package com.saludsystem.application.dtos.paciente.get.historialclinico.evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NotaDTO {

    @Schema(description = "ID de la evolucion del paciente", example = "Integer")
    private Long pacienteEvolucionNotaId;

    private LocalDateTime fecha;

    private String tipo;

    private String contenido;

    private UUID pacienteEvolucionId;

}