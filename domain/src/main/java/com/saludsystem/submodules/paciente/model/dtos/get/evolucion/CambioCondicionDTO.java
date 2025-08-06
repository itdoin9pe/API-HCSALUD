package com.saludsystem.submodules.paciente.model.dtos.get.evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CambioCondicionDTO {

    @Schema(example = "Integer")
    private Long evolucionCambioCondicionId;

    private LocalDateTime fecha;

    private String descripcion;

    private UUID pacienteEvolucionId;

}