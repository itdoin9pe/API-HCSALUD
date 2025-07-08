package com.saludsystem.paciente.application.dto.req.historialclinico.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CambioCondicionRequest {

    private LocalDateTime fecha;

    private String descripcion;

    private UUID pacienteEvolucionId;

}