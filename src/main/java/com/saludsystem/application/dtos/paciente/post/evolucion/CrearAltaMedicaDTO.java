package com.saludsystem.application.dtos.paciente.post.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CrearAltaMedicaDTO {

    private LocalDateTime fecha;

    private String resumenFinal;

    private UUID pacienteEvolucionId;

}