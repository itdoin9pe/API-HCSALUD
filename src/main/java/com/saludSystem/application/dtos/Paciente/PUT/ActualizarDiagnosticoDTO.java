package com.saludSystem.application.dtos.Paciente.PUT;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarDiagnosticoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pacienteId;

    private UUID pacienteDiagnosticoId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

}