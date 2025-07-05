package com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento;

import com.saludsystem.domain.model.paciente.Tratamiento.TipoProcedimiento;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProcedimientoDTO {

    private UUID pacienteProcedimientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;

}