package com.saludsystem.paciente.application.dto.res.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.base.historialclinico.evolucion.EvolucionBaseDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class EvolucionResponse extends EvolucionBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}