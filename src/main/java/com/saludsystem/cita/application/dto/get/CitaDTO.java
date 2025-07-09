package com.saludsystem.cita.application.dto.get;

import com.saludsystem.cita.application.dto.post.CrearCitaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CitaDTO extends CrearCitaDTO {
    private UUID citadoId;
}