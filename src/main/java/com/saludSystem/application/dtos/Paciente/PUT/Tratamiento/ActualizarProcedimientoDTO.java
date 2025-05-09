package com.saludSystem.application.dtos.Paciente.PUT.Tratamiento;

import com.saludSystem.domain.model.Paciente.Tratamiento.TipoProcedimiento;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarProcedimientoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pacienteProcedimientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;

}