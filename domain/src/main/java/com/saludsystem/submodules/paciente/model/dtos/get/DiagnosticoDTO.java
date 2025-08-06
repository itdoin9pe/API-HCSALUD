package com.saludsystem.submodules.paciente.model.dtos.get;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DiagnosticoDTO {

    private UUID pacienteDiagnosticoId;

    private UUID pacienteId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

}