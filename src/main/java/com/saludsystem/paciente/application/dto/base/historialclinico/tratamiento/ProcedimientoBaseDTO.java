package com.saludsystem.paciente.application.dto.base.historialclinico.tratamiento;

import com.saludsystem.paciente.domain.model.Tratamiento.TipoProcedimiento;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public abstract class ProcedimientoBaseDTO {

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;
}
