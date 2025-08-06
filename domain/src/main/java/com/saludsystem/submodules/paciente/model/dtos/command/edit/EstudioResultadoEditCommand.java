package com.saludsystem.submodules.paciente.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudioResultadoEditCommand extends BaseDTO {

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

    private String reporteTexto;

    private String urlImg;

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

    private LocalDateTime createdAt;

}