package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.command.evolucion.CrearEvolucionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EvolucionDTO extends CrearEvolucionDTO {
    private UUID pacienteEvolucionId;
}