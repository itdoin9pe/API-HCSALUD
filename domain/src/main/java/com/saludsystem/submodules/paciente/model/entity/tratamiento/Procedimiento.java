package com.saludsystem.submodules.paciente.model.entity.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Procedimiento {

    private UUID procedimientoId;
    private UUID pacienteId;
    private UUID doctorId;
    private TipoProcedimiento tipoProcedimiento;
    private String descripcion;
    private LocalDate fecha;
    private String resultado;

}
