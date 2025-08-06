package com.saludsystem.submodules.paciente.model.dtos.command.create;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoCreateCommand {

    private UUID pacienteId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

}