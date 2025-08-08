package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteAlergiaDTO {

    private UUID pacienteAlergiaId;

    private UUID pacienteId;

    private UUID alergiaId;

    private String observacion;

    @Schema(example = "0")
    private Integer estado;

}