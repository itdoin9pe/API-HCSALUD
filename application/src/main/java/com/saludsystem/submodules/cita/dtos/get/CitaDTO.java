package com.saludsystem.submodules.cita.dtos.get;

import com.saludsystem.submodules.cita.dtos.post.CrearCitaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CitaDTO extends CrearCitaDTO {
    private UUID citadoId;
}