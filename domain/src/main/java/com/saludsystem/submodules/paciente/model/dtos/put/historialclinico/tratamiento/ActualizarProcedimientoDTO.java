package com.saludsystem.submodules.paciente.model.dtos.put.historialclinico.tratamiento;

import com.saludsystem.submodules.BaseDTO;
import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;
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
