package com.saludsystem.submodules.paciente.dtos.get.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.dtos.post.historialclinico.tratamiento.CrearProcedimientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcedimientoDTO extends CrearProcedimientoDTO {
    private UUID pacienteProcedimientoId;
}