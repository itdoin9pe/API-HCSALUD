package com.saludsystem.application.paciente.dtos.get;

import com.saludsystem.application.dto.post.CrearEstudioResultadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstudioResultadoDTO extends CrearEstudioResultadoDTO {

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

}