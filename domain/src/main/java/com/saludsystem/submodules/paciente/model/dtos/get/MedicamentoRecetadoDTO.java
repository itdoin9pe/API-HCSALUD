package com.saludsystem.submodules.paciente.model.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class MedicamentoRecetadoDTO {

    private UUID medicamentoRecetadoId;

    private UUID medicamentoId;

    private String dosis;

    private String frecuencia;

    @Schema(example = "0")
    private Integer duracionDias;

    private String indicaciones;

}