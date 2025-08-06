package com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcedimientoCreateCommand {

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;

}