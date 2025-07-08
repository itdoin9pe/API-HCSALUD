package com.saludsystem.paciente.application.dto.res.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.base.historialclinico.evolucion.NotaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class NotaResponse extends NotaBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}