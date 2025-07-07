package com.saludsystem.cita.application.dto.res;

import com.saludsystem.cita.application.dto.CitaBaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CitaDTO extends CitaBaseDTO {

    private UUID citadoId;

}