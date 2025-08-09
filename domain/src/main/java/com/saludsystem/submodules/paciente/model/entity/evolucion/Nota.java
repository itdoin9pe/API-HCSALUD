package com.saludsystem.submodules.paciente.model.entity.evolucion;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Nota {

    private Long id;

    private LocalDateTime fecha;
    private String tipo;
    private String contenido;
    private UUID pacienteEvolucion;

}
