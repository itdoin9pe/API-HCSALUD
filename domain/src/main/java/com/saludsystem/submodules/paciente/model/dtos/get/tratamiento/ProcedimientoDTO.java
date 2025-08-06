package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.command.tratamiento.CrearProcedimientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcedimientoDTO extends CrearProcedimientoDTO {
    private UUID pacienteProcedimientoId;
}