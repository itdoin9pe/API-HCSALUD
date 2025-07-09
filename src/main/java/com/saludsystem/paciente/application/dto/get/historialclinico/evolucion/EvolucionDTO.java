package com.saludsystem.paciente.application.dto.get.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.post.historialclinico.evolucion.CrearEvolucionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EvolucionDTO extends CrearEvolucionDTO {
    private UUID pacienteEvolucionId;
}