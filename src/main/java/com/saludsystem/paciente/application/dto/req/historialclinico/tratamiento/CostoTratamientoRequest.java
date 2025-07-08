package com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.base.historialclinico.tratamiento.CostoTratamientoBaseDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class CostoTratamientoRequest extends CostoTratamientoBaseDTO {

    private UUID pacienteCostoTratamientoId;

}