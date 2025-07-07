package com.saludsystem.paciente.application.dto.res;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class DiagnosticoDTO {

    private UUID pacienteId;

    private UUID pacienteDiagnosticoId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

}