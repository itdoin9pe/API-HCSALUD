package com.saludsystem.paciente.application.dto.req.historialclinico.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AltaMedicaRequest {

    private LocalDateTime fecha;

    private String resumenFinal;

    private UUID pacienteEvolucionId;

}