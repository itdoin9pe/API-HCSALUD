package com.saludsystem.submodules.paciente.model.entity.evolucion;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class AltaMedica {

    private Long id;
    private LocalDateTime fecha;
    private String resumenFinal;
    private UUID pacienteEvolucionId;

}
