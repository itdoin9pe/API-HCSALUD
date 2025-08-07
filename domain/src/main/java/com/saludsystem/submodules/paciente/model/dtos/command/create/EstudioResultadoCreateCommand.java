package com.saludsystem.submodules.paciente.model.dtos.command.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudioResultadoCreateCommand {

    private String reporteTexto;

    private String urlImg;

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

}