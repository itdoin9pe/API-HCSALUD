package com.saludsystem.submodules.paciente.mapper.historialclinico.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AltaMedicaMapper {
    private LocalDateTime fecha;

    private String resumenFinal;

    private UUID pacienteEvolucionId;
}