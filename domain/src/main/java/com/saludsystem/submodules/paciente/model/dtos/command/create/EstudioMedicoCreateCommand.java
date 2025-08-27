package com.saludsystem.submodules.paciente.model.dtos.command.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudioMedicoCreateCommand {

    private String tipo;

    private String descripcion;

    private String estado;

    private UUID pacienteId;

    private UUID doctorId;

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

}