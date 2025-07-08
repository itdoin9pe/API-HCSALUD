package com.saludsystem.paciente.application.dto.base.historialclinico.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class CambioCondicionBaseDTO {
    private LocalDateTime fecha;

    private String descripcion;

    private UUID pacienteEvolucionId;
}
