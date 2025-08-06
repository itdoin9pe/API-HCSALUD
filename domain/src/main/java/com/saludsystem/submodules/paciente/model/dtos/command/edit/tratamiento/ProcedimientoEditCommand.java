package com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento;

import com.saludsystem.submodules.BaseDTO;
import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcedimientoEditCommand extends BaseDTO {

    private UUID pacienteProcedimientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;
}
