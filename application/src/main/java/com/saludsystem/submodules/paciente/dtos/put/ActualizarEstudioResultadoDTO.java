package com.saludsystem.submodules.paciente.dtos.put;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarEstudioResultadoDTO extends BaseDTO {

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

    private String reporteTexto;

    private String urlImg;

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

    private LocalDateTime createdAt;

}