package com.saludsystem.application.dtos.cita.get;

import com.saludsystem.application.dtos.cita.CitaBaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CitaDTO extends CitaBaseDTO {

    private UUID citadoId;

}