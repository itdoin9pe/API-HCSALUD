package com.saludsystem.application.paciente.dtos.put.historialclinico.tratamiento;

import com.saludsystem.domain.model.tratamiento.TipoProcedimiento;
import com.shared.application.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarProcedimientoDTO extends BaseDTO {

    private UUID pacienteProcedimientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;
}
