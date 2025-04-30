package com.saludSystem.application.dtos.Paciente.PUT;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarAnalisisGeneralDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pacienteId;

    private UUID pacienteAnalisisGeneralId;

    private UUID especialidadId;

    private UUID doctorId;

    private String tipoOrtodoncia;

    private String duracionOrtodoncia;

    private LocalDate fechaInicioOrtodoncia;

    private LocalDate fechaFinOrtodoncia;

    private String anclajeSuperiorOrtodoncia;

    private String anclajeInferiorOrtodoncia;

    private String notaOrtodoncia;

}