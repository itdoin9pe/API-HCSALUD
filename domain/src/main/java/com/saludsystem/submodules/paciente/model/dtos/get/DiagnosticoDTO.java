package com.saludsystem.submodules.paciente.model.dtos.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DiagnosticoDTO {

	private UUID pacienteDiagnosticoId;

    private UUID pacienteId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

    
}