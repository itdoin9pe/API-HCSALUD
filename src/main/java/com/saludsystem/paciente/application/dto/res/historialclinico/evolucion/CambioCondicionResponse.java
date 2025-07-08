package com.saludsystem.paciente.application.dto.res.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.base.historialclinico.evolucion.CambioCondicionBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class CambioCondicionResponse extends CambioCondicionBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}