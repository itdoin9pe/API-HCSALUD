package com.saludsystem.submodules.paciente.model.dtos.post.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CrearProcedimientoDTO {

    private UUID pacienteId;

    private UUID doctorId;

    private TipoProcedimiento tipoProcedimiento;

    private String descripcion;

    private LocalDate fecha;

    private String resultado;
}