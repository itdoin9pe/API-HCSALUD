package com.saludsystem.application.paciente.dtos.get.historialclinico.tratamiento;

import com.saludsystem.application.paciente.dtos.post.historialclinico.tratamiento.CrearCostoTratamientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CostoTratamientoDTO extends CrearCostoTratamientoDTO {
    private UUID pacientePlanTratamientoId;
}