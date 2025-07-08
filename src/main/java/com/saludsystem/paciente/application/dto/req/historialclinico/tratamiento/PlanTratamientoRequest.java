package com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.base.historialclinico.tratamiento.PlanTratamientoBaseDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class PlanTratamientoRequest extends PlanTratamientoBaseDTO {

    private UUID pacientePlanTratamientoId;

}