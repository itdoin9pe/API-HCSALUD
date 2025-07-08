package com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento;

import com.saludsystem.paciente.domain.model.Tratamiento.TipoProcedimiento;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProcedimientoRequest {

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;

}