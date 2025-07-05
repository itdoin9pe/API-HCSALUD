package com.saludsystem.application.dtos.paciente.post.historialclinico.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CrearCambioCondicionDTO {

    private LocalDateTime fecha;

    private String descripcion;

    private UUID pacienteEvolucionId;

}