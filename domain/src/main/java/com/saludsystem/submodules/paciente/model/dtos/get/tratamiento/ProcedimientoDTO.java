package com.saludsystem.submodules.paciente.model.dtos.get.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProcedimientoDTO {

    private UUID pacienteProcedimientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;

}