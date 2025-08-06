package com.saludsystem.submodules.paciente.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudioMedicoEditCommand extends BaseDTO {

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

    private String tipo;

    private String descripcion;

    private LocalDateTime requestAt;

    private LocalDateTime performedAt;

    private String estado;

    private UUID pacienteId;

    private UUID doctorId;

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

}