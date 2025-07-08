package com.saludsystem.paciente.application.dto.req.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.base.historialclinico.evolucion.EvolucionBaseDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class EvolucionRequest extends EvolucionBaseDTO {

    private UUID pacienteEvolucionId;

}