package com.saludsystem.application.paciente.dtos.post;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CrearDiagnosticoDTO {

    private UUID pacienteId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

}