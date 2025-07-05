package com.saludsystem.application.dtos.cita.put;

import com.saludsystem.application.dtos.cita.CitaBaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarCitaDTO extends CitaBaseDTO {
    private UUID hospitalId;
    private UUID userId;
    private UUID citadoId;
}