package com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.base.historialclinico.tratamiento.CostoTratamientoBaseDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class CostoTratamientoResponse extends CostoTratamientoBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}