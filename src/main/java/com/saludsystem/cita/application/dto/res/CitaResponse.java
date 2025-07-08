package com.saludsystem.cita.application.dto.res;

import com.saludsystem.cita.application.dto.CitaBaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CitaResponse extends CitaBaseDTO {

    private UUID citadoId;

}