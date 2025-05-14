package com.saludSystem.application.dtos.Paciente.POST.Evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CrearNotaDTO {

    private LocalDateTime fecha;

    private String tipo;

    private String contenido;

    private UUID pacienteEvolucionId;

}