package com.saludsystem.submodules.paciente.model.dtos.command.create;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoRecetadoCreateCommand {

    private UUID pacienteRecetaId;

    private UUID medicamentoId;

    private String dosis;

    private String frecuencia;

    @Schema(example = "0")
    private Integer duracionDias;

    private String indicaciones;

}