package com.saludsystem.paciente.application.dto.req;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class DiagnosticoRequest {

    private UUID pacienteId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

}