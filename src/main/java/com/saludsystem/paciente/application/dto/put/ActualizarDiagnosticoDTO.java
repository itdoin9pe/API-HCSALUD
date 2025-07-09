package com.saludsystem.paciente.application.dto.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarDiagnosticoDTO extends BaseDTO {

    private UUID pacienteId;

    private UUID pacienteDiagnosticoId;

    private String enfermedadId;

    private LocalDate fecha;

    private String descripcion;

}