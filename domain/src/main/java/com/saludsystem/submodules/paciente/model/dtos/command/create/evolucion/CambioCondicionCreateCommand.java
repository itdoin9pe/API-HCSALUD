package com.saludsystem.submodules.paciente.model.dtos.command.evolucion;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CambioCondicionCreateCommand {
    private LocalDateTime fecha;

    private String descripcion;

    private UUID pacienteEvolucionId;
}