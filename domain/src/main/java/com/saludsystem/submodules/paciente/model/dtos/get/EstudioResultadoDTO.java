package com.saludsystem.submodules.paciente.model.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstudioResultadoDTO {

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

    private String reporteTexto;

    private String urlImg;

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

}