package com.saludsystem.submodules.paciente.model.dtos.edit;

import com.saludsystem.submodules.BaseDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoEditCommand extends BaseDTO {

    private UUID pacienteId;

    private UUID pacienteDiagnosticoId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

}