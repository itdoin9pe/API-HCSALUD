package com.saludsystem.application.dtos.cita.get;

import com.saludsystem.application.dtos.cita.CitaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class CitaDTO extends CitaBaseDTO {

    private UUID citadoId;

}