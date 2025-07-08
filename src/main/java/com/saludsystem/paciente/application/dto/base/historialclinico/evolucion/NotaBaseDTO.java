package com.saludsystem.paciente.application.dto.base.historialclinico.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class NotaBaseDTO {
    private LocalDateTime fecha;

    private String tipo;

    private String contenido;

    private UUID pacienteEvolucionId;
}
