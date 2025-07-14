package com.saludsystem.application.paciente.dtos.get;

import com.saludsystem.application.paciente.dtos.post.CrearEstudioMedicoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstudioMedicoDTO extends CrearEstudioMedicoDTO {

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

}