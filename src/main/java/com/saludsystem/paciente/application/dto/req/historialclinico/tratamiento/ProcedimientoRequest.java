package com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.base.historialclinico.tratamiento.ProcedimientoBaseDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class ProcedimientoRequest extends ProcedimientoBaseDTO {

    private UUID pacienteProcedimientoId;

}