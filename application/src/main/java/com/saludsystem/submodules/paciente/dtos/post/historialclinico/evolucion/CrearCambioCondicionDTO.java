package com.saludsystem.submodules.paciente.dtos.post.historialclinico.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CrearCambioCondicionDTO {
    private LocalDateTime fecha;

    private String descripcion;

    private UUID pacienteEvolucionId;
}